package com.pincodedeatil.service;


import com.pincodedeatil.Exception.PinCodeNotFoundException;
import com.pincodedeatil.dto.PinCodeRequestDto;
import com.pincodedeatil.dto.PinCodeResponseDto;
import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.repository.PinCodeCustomRepositoryDetail;
import com.pincodedeatil.repository.PinCodeRepositoryDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PinCodeService {
    private final RestTemplate restTemplate;

    private final PinCodeRepositoryDetail pinCodeRepositoryDetail;

    private final PinCodeCustomRepositoryDetail pinCodeCustomRepositoryDetail;

    public PinCodeResponseDto getPinCodeDetail(String pincode) throws PinCodeNotFoundException {


       PinCodeDetail  fromDb = pinCodeRepositoryDetail.findById(pincode)
                .orElseThrow(() -> new PinCodeNotFoundException("Not Found: " + pincode));

   return new PinCodeResponseDto(fromDb.getPincode(),
                                 fromDb.getCity(),
                                 fromDb.getState(),
                                 fromDb.getCountry());
    }
    //1.use the derived query
    public PinCodeResponseDto getPinCodeDetailByPinCode(String pinCode){
        PinCodeDetail pinCodeDetail = pinCodeRepositoryDetail.findByPinCode(pinCode);
        return  new PinCodeResponseDto(pinCodeDetail.getPincode(),
                pinCodeDetail.getCity(),
                pinCodeDetail.getState(),
                pinCodeDetail.getCountry());
    }

    //2.CrieteriaBuilderQuery
    public List<PinCodeDetail> getFilterData(String city,String state){
        return pinCodeCustomRepositoryDetail.findWithCustomeFilter(city,state);
    }

    //JPQL (Java Persistence Query Language)
    public List<PinCodeDetail> findByCityUsingJPQL(String city){
        return pinCodeRepositoryDetail.finfByCityJPQL(city);
    }

    //Native Query
    public List<PinCodeDetail> getByCityUsingNativeSql(String city){
        return pinCodeRepositoryDetail.getCityNativeSQL(city);
    }

    public void saveIntoDatabase(PinCodeRequestDto pinCodeRequestDto) {

        PinCodeDetail pinCodeDetail = new PinCodeDetail();

        pinCodeDetail.setPincode(pinCodeRequestDto.getPincode());
        pinCodeDetail.setCity(pinCodeRequestDto.getCity());
        pinCodeDetail.setCountry(pinCodeRequestDto.getCountry());
        pinCodeDetail.setState(pinCodeRequestDto.getState());

        pinCodeRepositoryDetail.save(pinCodeDetail);

    }

}
