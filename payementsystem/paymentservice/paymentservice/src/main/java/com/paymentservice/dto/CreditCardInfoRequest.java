package com.paymentservice.dto;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardInfoRequest {
    private String cardholdername;
    private String cardtoken;
    private String cardtype;
    private String expirymonth;
    private String expiryyear;
    private String maskedcardnumber;
}
