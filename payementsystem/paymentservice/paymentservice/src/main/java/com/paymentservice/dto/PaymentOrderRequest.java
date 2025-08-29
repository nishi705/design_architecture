package com.paymentservice.dto;

import com.paymentservice.model.PaymentEvent;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentOrderRequest {
    private String buyerAccount;
    private String amount;
    private String currency;
    private String checkoutId;           // ✅ FK comes as string from JSON
    private String paymentOrderStatus;
    private boolean ledgerUpdated;
    private boolean walletUpdated;
}
