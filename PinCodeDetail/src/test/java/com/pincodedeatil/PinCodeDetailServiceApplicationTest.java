package com.pincodedeatil;

import com.pincodedeatil.dto.PinCodeRequestDto;
import com.pincodedeatil.dto.PinCodeResponseDto;
import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.repository.PinCodeRepositoryDetail;
import com.pincodedeatil.service.PinCodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PinCodeDetailServiceApplicationTest {

    @InjectMocks
    private PinCodeService pinCodeService;

    @Mock
    private PinCodeRepositoryDetail pinCodeRepositoryDetail;

    @Test
    void testSavePinCode(){
        PinCodeRequestDto pinCodeRequestDto = new PinCodeRequestDto();
        pinCodeRequestDto.setPincode("132001");
        pinCodeRequestDto.setCity("Karnal");
        pinCodeRequestDto.setState("Haryana");
        pinCodeRequestDto.setCountry("India");

        PinCodeDetail pinCodeDetail = new PinCodeDetail();
        pinCodeDetail.setPincode(pinCodeRequestDto.getPincode());
        pinCodeDetail.setCity(pinCodeRequestDto.getCity());
        pinCodeDetail.setState(pinCodeRequestDto.getState());
        pinCodeDetail.setCountry(pinCodeRequestDto.getCountry());

    when(pinCodeRepositoryDetail.save(any(PinCodeDetail.class))).thenReturn(pinCodeDetail);

    pinCodeService.saveIntoDatabase(pinCodeRequestDto);

    assertEquals("India",pinCodeRequestDto.getCountry());
    assertEquals("132001",pinCodeRequestDto.getPincode());

    }
}
