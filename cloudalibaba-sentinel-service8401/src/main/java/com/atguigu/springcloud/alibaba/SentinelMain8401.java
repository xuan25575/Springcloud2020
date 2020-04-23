package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author huang_2
 * @Date 2020/4/22 7:11 下午
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class,args);
    }
}
