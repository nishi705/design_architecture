package com.paymentservice.controller;


import com.paymentservice.dto.PaymentOrderRequest;
import com.paymentservice.model.PaymentEvent;
import com.paymentservice.model.PaymentOrder;
import com.paymentservice.repository.PaymentEventRepository;
import com.paymentservice.repository.PaymentOrderRepository;
import com.paymentservice.service.PaymentOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentOrderController {

    private final PaymentOrderService paymentOrderService;
    private final PaymentOrderRepository paymentOrderRepository;
    private final PaymentEventRepository paymentEventRepository;

        @PostMapping("/order")
        @ResponseStatus(HttpStatus.CREATED)
       public String paymentOrderdata(@RequestBody PaymentOrderRequest paymentOrderRequest){
            paymentOrderService.savePaymentOrder(paymentOrderRequest);

            return "order saved";

        }

}
