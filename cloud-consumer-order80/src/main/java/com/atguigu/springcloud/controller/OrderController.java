package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.config.ApplicationContextConfig;
import com.atguigu.springcloud.entity.CommentResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huang_2
 * @Date 2020/4/18 1:02 下午
 * @Description TODO
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String PATH_URI = "http://localhost:8001";

    private static final String PATH_URI = "http://CLOUD-PAYMENT-SERVICE";



    @PostMapping("/consumer/payment/create")
    public CommentResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PATH_URI+"/payment/create",payment,CommentResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PATH_URI+"/payment/get/"+id,CommentResult.class);
    }


}
