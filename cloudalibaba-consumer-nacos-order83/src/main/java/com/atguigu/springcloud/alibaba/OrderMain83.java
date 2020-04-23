package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huang_2
 * @Date 2020/4/20 5:28 下午
 * @Description TODO
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class,args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
