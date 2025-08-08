package com.pincodedeatil.repository;

import com.pincodedeatil.model.PinCodeDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PinCodeCustomRepositoryDetail {
    List<PinCodeDetail> findWithCustomeFilter(String city, String state);
}
