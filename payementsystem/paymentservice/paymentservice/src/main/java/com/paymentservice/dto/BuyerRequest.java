package com.paymentservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyerRequest {

    private String name;
    private String emailId;
    private String phnumber;
}
