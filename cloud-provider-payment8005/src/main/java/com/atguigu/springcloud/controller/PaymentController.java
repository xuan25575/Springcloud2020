package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author huang_2
 * @Date 2020/4/18 4:26 下午
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;


    // 挂载zk的是临时节点
    @GetMapping("/payment/zk")
    public String paymentZK(){
        return "SpringCloud with zookeeper:" +serverPort+" \t "+ UUID. randomUUID ().toString() ;
    }
}
