package com.pincodedeatil.repository;

import com.pincodedeatil.model.PinCodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PinCodeRepositoryDetail extends JpaRepository<PinCodeDetail,String> {
    PinCodeDetail findByPinCode(String pinCode);

    //here JPQL works on Entity and its field
    @Query("Select p from PinCodeDetail p where p.city = :city")
    List<PinCodeDetail> finfByCityJPQL(@Param("city")String city);

    //here Native sql works on table and column
    @Query(value = "SELECT * FROM pincodedetail WHERE city = :city", nativeQuery = true)
    List<PinCodeDetail> getCityNativeSQL(String city);
}
