package com.pincodedeatil.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PinCodeResponseDto {

    private String pincode;
    private String city;
    private String state;
    private String country;
}
