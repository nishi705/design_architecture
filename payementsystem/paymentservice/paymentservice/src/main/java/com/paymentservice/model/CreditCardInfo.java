package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "creditcardinfo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardInfo {

    @Id
    private String id;
    private String cardholdername;
    private String cardtoken;
    private String cardtype;
    private String expirymonth;
    private String expiryyear;
    private String maskedcardnumber;

    @ManyToOne
    @JoinColumn(name = "buyer_id",nullable = false)
    private Buyer buyer;

}
