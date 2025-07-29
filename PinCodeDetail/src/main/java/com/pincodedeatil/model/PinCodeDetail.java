package com.pincodedeatil.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pincodedetails")
public class PinCodeDetail {
    private String pincode;
    private String city;
    private String state;
    private String country;
}
