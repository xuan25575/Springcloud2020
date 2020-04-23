package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huang_2
 * @Date 2020/4/20 5:14 下午
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/get/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return "hello nacos id:"+id + "\t port :"+this.serverPort;
    }


    // open feign 调用
    @GetMapping("/payment/{id}")
    public String getId(@PathVariable("id") Integer id){
        return "payment id:"+id + "\t port :"+this.serverPort;
    }


}
