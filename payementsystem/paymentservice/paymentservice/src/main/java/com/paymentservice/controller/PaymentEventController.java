package com.paymentservice.controller;


import com.paymentservice.dto.PaymentEventRequest;
import com.paymentservice.model.PaymentEvent;
import com.paymentservice.repository.PaymentEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentEventController {

    private final PaymentEventRepository paymentEventRepository;

    @PostMapping("/v1/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public String paymentEventData(@RequestBody PaymentEventRequest paymentEventRequest){
        PaymentEvent event= PaymentEvent.builder()
                .checkoutId("po_" + UUID.randomUUID().toString())
                .buyerInfo(paymentEventRequest.getBuyerInfo())
                .creditCardInfo(paymentEventRequest.getCreditCardInfo())
                .isPaymentDone(paymentEventRequest.isPaymentDone())
                .sellerInfo(paymentEventRequest.getSellerInfo())
                .build();
        paymentEventRepository.save(event);
        return "checkoutId of event is"+event.getCheckoutId();
    }
}
