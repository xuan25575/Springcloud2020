package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author huang_2
 * @Date 2020/4/18 4:45 下午
 * @Description TODO
 */
@RestController
@Slf4j
public class OrderZkController {


    public static final String INVOKE_URL = "http://cloud-payment-service" ;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
