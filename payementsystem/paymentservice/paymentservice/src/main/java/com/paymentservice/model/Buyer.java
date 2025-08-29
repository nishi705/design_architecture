package com.paymentservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "buyer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Buyer {

    @Id
    private String id;
    private String name;
    private String emailId;
    private String phnumber;
}
