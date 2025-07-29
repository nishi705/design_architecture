package com.pincodedeatil.repository;

import com.pincodedeatil.model.PinCodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PinCodeRepositoryDetail extends JpaRepository<PinCodeDetail,String> {
    Optional<PinCodeDetail> getByPinCodeDetail(String pincode);
}
