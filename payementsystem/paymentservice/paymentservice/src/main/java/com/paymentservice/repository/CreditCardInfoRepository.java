package com.paymentservice.repository;

import com.paymentservice.model.CreditCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardInfoRepository extends JpaRepository<CreditCardInfo,String> {
}
