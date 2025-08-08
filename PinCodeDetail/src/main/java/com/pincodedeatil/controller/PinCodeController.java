package com.pincodedeatil.controller;


import com.pincodedeatil.Exception.PinCodeNotFoundException;
import com.pincodedeatil.dto.PinCodeRequestDto;
import com.pincodedeatil.dto.PinCodeResponseDto;
import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.service.PinCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pincode")
@RequiredArgsConstructor
@Slf4j
public class PinCodeController {
private final PinCodeService pinCodeService;

@PostMapping("/data")
@ResponseStatus(HttpStatus.CREATED)

public ResponseEntity<?> savePinCode(@RequestHeader("Idempotency-Key") String idempotencyKey,@RequestBody PinCodeRequestDto pinCodeRequestDto){
   log.info("idempotent key:"+idempotencyKey);
    pinCodeService.saveIntoDatabase(pinCodeRequestDto);
    return ResponseEntity.ok("Pincodedetail has been saved");
}

    @GetMapping("/{pincode}")
    public ResponseEntity<?> getPinCode(@PathVariable String pincode) throws PinCodeNotFoundException {
        PinCodeResponseDto pinCodeDetail = pinCodeService.getPinCodeDetail(pincode);
        return ResponseEntity.ok(Map.of("pincodedetail",pinCodeDetail));
    }

}
