package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommentResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author huang_2
 * @Date 2020/4/19 12:15 下午
 * @Description TODO
 */
@RestController
public class PaymentFeignController {


    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeout(){
        return paymentFeignService.feignTimeout();
    }
}
