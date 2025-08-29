package com.paymentservice.service;

import com.paymentservice.dto.BuyerRequest;
import com.paymentservice.model.Buyer;
import com.paymentservice.repository.UserRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;

    public Buyer saveUser(BuyerRequest buyerRequest) {
        Buyer buyer = Buyer.builder()
                .id("user_" + UUID.randomUUID().toString())
                        .name(buyerRequest.getName())
                                .emailId(buyerRequest.getEmailId())
                                        .phnumber(buyerRequest.getPhnumber())
                                                   .build();

        userRegistrationRepository.save(buyer);

        return buyer;

    }
}
