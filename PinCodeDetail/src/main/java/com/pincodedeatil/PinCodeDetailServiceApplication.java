package com.pincodedeatil;

import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.repository.PinCodeRepositoryDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PinCodeDetailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinCodeDetailServiceApplication.class, args);
    }

        @Bean
        public CommandLineRunner saveData(PinCodeRepositoryDetail pinCodeRepositoryDetail) {
            return args -> {
                PinCodeDetail pinCodeDetail = new PinCodeDetail();
                pinCodeDetail.setState("Karnataka");
                pinCodeDetail.setCity("Bangalore");
                pinCodeDetail.setCountry("India");
                pinCodeDetail.setPincode("56789");

                pinCodeRepositoryDetail.save(pinCodeDetail);
            };


    }
}