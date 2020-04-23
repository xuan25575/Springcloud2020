package com.atguigu.springcloud.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author huang_2
 * @Date 2020/4/19 4:22 下午
 * @Description TODO
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fallback";
    }
}
