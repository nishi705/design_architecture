package com.paymentservice.controller;


import com.paymentservice.dto.BuyerRequest;
import com.paymentservice.dto.CreditCardInfoRequest;
import com.paymentservice.model.Buyer;
import com.paymentservice.model.CreditCardInfo;
import com.paymentservice.repository.CreditCardInfoRepository;
import com.paymentservice.repository.UserRegistrationRepository;
import com.paymentservice.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;
    private final UserRegistrationRepository userRegistrationRepository;
    private final CreditCardInfoRepository creditCardInfoRepository;
    @PostMapping("/user/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public String userRegistration(@RequestBody BuyerRequest buyerRequest){
       Buyer user =  userRegistrationService.saveUser(buyerRequest);
        return user.getId()+"User registered successfully";
    }


   @PostMapping("/user/buyers/{buyerId}/creditcard")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> creditCardInfoDetail(@PathVariable("buyerId") String buyerId, @RequestBody CreditCardInfoRequest creditCardInfoRequest) {
       Optional<Buyer> buyer = userRegistrationRepository.findById(buyerId);
       if (buyer.isEmpty()) {
           return ResponseEntity.notFound().build();
       }

       CreditCardInfo creditCardInfo = CreditCardInfo.builder()
               .id("cred_"+ UUID.randomUUID())
               .cardholdername(creditCardInfoRequest.getCardholdername())
               .cardtoken(creditCardInfoRequest.getCardtoken())
               .cardtype(creditCardInfoRequest.getCardtype())
               .expirymonth(creditCardInfoRequest.getExpirymonth())
               .expiryyear(creditCardInfoRequest.getExpiryyear())
               .maskedcardnumber(creditCardInfoRequest.getMaskedcardnumber())
               .buyer(buyer.get())
               .build();
       CreditCardInfo saveCreditCardInfo = creditCardInfoRepository.save(creditCardInfo);
       return ResponseEntity.ok(saveCreditCardInfo.getId());
   }

}
