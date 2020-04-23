package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author huang_2
 * @Date 2020/4/22 7:12 下午
 * @Description TODO
 */
@RestController
public class FlowLimitController {


    @Autowired
    private PaymentService paymentService;

    @GetMapping("/testA")
    public String testA(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testA";
    }

    @GetMapping("/testB")
    public String testB(){
//        int a = 10 /0;
        return "testB";
    }


    @GetMapping("/consumer/payment/{id}")
    public String getId(@PathVariable("id") Integer id){
        return paymentService.getId(id);
    }
}
