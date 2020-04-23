package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommentResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huang_2
 * @Date 2020/4/18 11:16 上午
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "payment/create")
    public CommentResult create(@RequestBody  Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果 端口："+ serverPort, result);
        if(result> 0){
            return new CommentResult(200,"插入数据库成功,端口："+serverPort, result);
        }else{
            return new CommentResult(444,"插入数据库失败");
        }

    }

    @GetMapping(value = "payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果 ", payment);
        if(payment!= null){
            return new CommentResult(200,"查询成功，端口："+serverPort, payment);
        }else{
            return new CommentResult(444,"没有查询到该记录");
        }
    }



    @GetMapping("/payment/discover")
    public Object discover(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****** service "+ service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info(instance.getHost()+ " " +instance.getInstanceId() +" " + instance.getScheme());

        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String feignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.serverPort;
    }





}
