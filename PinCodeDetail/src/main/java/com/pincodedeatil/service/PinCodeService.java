package com.pincodedeatil.service;


import com.pincodedeatil.Exception.PinCodeNotFoundException;
import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.repository.PinCodeRepositoryDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PinCodeService {

    private final PinCodeRepositoryDetail pinCodeRepositoryDetail;

    public PinCodeDetail getPinCodeDetail(String pincode) throws PinCodeNotFoundException {
       PinCodeDetail  fromDb = pinCodeRepositoryDetail.findById(pincode)
                .orElseThrow(() -> new PinCodeNotFoundException("Not Found: " + pincode));

   return fromDb;
    }
}
