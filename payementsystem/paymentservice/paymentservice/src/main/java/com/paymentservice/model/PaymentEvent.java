package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "paymentevent")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {

    @Id
    @Column(name = "checkout_id", nullable = false, unique = true)
    private String checkoutId;
    private String buyerInfo;
    private String sellerInfo;
    // You can store credit card info as JSON (if using PostgreSQL with @Lob or @Column)
    @Lob
    private String creditCardInfo;
    private boolean isPaymentDone;

    @OneToMany(mappedBy = "paymentEvent")
    private List<PaymentOrder> paymentOrderList;
}
