package com.paymentservice.service;

import com.paymentservice.dto.PaymentOrderRequest;
import com.paymentservice.model.PaymentEvent;
import com.paymentservice.model.PaymentOrder;
import com.paymentservice.repository.PaymentEventRepository;
import com.paymentservice.repository.PaymentOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentOrderService {

    private final PaymentOrderRepository paymentOrderRepository;
    private final PaymentEventRepository paymentEventRepository;

    public void savePaymentOrder(PaymentOrderRequest paymentOrderRequest){
        PaymentEvent event = paymentEventRepository.findById(paymentOrderRequest.getCheckoutId())
                .orElseThrow(()->new RuntimeException("event not fount for checkoutId"+paymentOrderRequest.getCheckoutId()));

        PaymentOrder paymentOrder = PaymentOrder.builder()
                .paymentOrderId("po"+ UUID.randomUUID())
                .paymentEvent(event)
                .paymentOrderStatus(paymentOrderRequest.getPaymentOrderStatus())
                .amount(paymentOrderRequest.getAmount())
                .currency(paymentOrderRequest.getCurrency())
                .ledgerUpdated(paymentOrderRequest.isLedgerUpdated())
                .walletUpdated(paymentOrderRequest.isWalletUpdated())
                .buyerAccount(paymentOrderRequest.getBuyerAccount())
                .build();
        paymentOrderRepository.save(paymentOrder);
    }
}
