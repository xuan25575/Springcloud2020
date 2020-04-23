package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huang_2
 * @Date 2020/4/18 4:44 下午
 * @Description TODO
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class);
    }


    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
