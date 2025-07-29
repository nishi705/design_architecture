package com.pincodedeatil.controller;


import com.pincodedeatil.Exception.PinCodeNotFoundException;
import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.service.PinCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pincode")
@RequiredArgsConstructor
public class PinCodeController {
private final PinCodeService pinCodeService;



    @GetMapping("/{pincode}")
    public ResponseEntity<?> getPinCode(@PathVariable String pincode) throws PinCodeNotFoundException {
        PinCodeDetail pinCodeDetail = pinCodeService.getPinCodeDetail(pincode);
        return ResponseEntity.ok(Map.of("pincodedetail",pinCodeDetail));
    }
}
