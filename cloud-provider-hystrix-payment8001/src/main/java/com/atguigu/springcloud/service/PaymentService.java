package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author huang_2
 * @Date 2020/4/19 3:42 下午
 * @Description TODO
 */
@Service
public class PaymentService {

    // 服务降级
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK  +id="+id;
    }


    @HystrixCommand(fallbackMethod = "failHandle",commandProperties = {
         @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
     }
    )
    public String paymentInfo_TimeOut(Integer id){
        //int age = 10 /0;
        try {
            TimeUnit.SECONDS.sleep(3) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK  +id="+id + "耗时：3秒";
    }


    public String failHandle(@PathVariable("id") Integer id){
        return "8001 系统报错,稍后重试";
    }





    // 服务熔断

    @HystrixCommand(fallbackMethod = "failHandle2",commandProperties = {
            // 当满足一定的阈值的时候 这里是10个请求 (默认10秒钟超过20个请求次数)
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗体。
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //当失败率达到一定的时候这里是60% (默认10秒内超过50%的请求次数)
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60"),
            // 开启断路器
            @HystrixProperty(name ="circuitBreaker.enabled",value = "true"),
        }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id <0){
            throw  new RuntimeException("id 不能是负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return "流水号："+ simpleUUID;
    }

    public String failHandle2(@PathVariable("id") Integer id){
        return "id 不能是负数 id:" +id;
    }

}
