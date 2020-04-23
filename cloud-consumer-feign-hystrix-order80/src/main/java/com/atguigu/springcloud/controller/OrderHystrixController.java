package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huang_2
 * @Date 2020/4/19 3:52 下午
 * @Description TODO
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK (@PathVariable("id" ) Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "failHandle",commandProperties = {
//            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    }
//    )
    public String paymentInfo_TimeOut(@PathVariable("id" ) Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String failHandle(@PathVariable("id") Integer id){
        return "80系统报错,稍后重试";
    }


    public String payment_Global_FallbackMethod(){
        return "Global 全局处理， 系统报错,稍后重试";
    }

}
