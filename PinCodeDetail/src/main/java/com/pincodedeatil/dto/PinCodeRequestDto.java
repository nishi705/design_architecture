package com.pincodedeatil.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PinCodeRequestDto {
//    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
//            message = "username must be of 6 to 12 length with no special characters")
    private String pincode;
    private String city;
    private String state;
    private String country;

}
