package com.pincodedeatil.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pincodedetail")
//@Table(name = "pincodedetail",uniqueConstraints = {@UniqueConstraint(columnNames = {"pincode","country"})})
public class PinCodeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Column(unique=true)
    private String pincode;
    private String city;
    private String state;
    private String country;

    /*
    ERROR: duplicate key value violates unique constraint "uk_f8ewkbkud5kl1hp16q60u4w9y"
  Detail: Key (pincode)=(56789) already exists.
     */
}
