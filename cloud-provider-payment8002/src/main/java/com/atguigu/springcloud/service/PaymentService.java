package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @Author huang_2
 * @Date 2020/4/18 11:17 上午
 * @Description TODO
 */
public interface PaymentService {

    /**
     *  新增
     * @param payment
     * @return int
     */
    int create(Payment payment);

    /**
     * 查询
     * @param id
     * @return Payment
     */
    Payment getPaymentById(Long id);
}
