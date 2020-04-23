package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author huang_2
 * @Date 2020/4/23 1:13 下午
 * @Description TODO
 */
@Component
@FeignClient(value="nacos-payment-provider",fallback =PaymentFallbackService.class )
public interface PaymentService {


     @GetMapping("/payment/{id}")
     String getId(@PathVariable("id") Integer id);

}
