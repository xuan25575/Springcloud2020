package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @Author huang_2
 * @Date 2020/4/23 1:15 下午
 * @Description TODO
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String getId(Integer id) {
        return "fallback ";
    }
}
