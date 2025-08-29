package com.paymentservice.repository;

import com.paymentservice.model.PaymentEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentEventRepository extends JpaRepository<PaymentEvent,String> {
    PaymentEvent findByCheckoutId(String checkoutId);
}
