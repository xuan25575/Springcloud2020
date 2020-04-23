package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author huang_2
 * @Date 2020/4/18 11:10 上午
 * @Description TODO
 */
@Mapper
public interface  PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
