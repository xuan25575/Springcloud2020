package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommentResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author huang_2
 * @Date 2020/4/19 12:06 下午
 * @Description TODO
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


     @GetMapping(value = "payment/get/{id}")
     CommentResult<Payment> getPaymentById(@PathVariable("id")Long id);


    @GetMapping("/payment/feign/timeout")
    String feignTimeout();
}
