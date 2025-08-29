package com.paymentservice.repository;

import com.paymentservice.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<Buyer,String> {
}
