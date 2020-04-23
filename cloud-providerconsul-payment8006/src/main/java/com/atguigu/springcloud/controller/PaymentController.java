package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author huang_2
 * @Date 2020/4/18 5:20 下午
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with consul:" +serverPort+" \t "+ UUID. randomUUID ().toString() ;
    }
}
