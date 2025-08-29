package com.paymentservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentEventRequest {
    private String checkoutId;   // required (PK)
    private String buyerInfo;
    private String sellerInfo;
    private String creditCardInfo;  // keep as String (JSON or encrypted)
    private boolean isPaymentDone;
}
