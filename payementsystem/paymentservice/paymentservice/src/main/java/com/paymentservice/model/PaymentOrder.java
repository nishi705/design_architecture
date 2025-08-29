package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paymentorder")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrder {

    @Id
    @Column(name = "payment_order_id", nullable = false, unique = true)
    private String paymentOrderId;

    private String buyerAccount;
    private String amount;
    private String currency;

    // ✅ Many PaymentOrders -> One PaymentEvent
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkout_id", nullable = false)  // FK column
    private PaymentEvent paymentEvent;

    private String paymentOrderStatus;
    private boolean ledgerUpdated;
    private boolean walletUpdated;
}
