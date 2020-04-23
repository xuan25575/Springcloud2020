package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huang_2
 * @Date 2020/4/18 1:04 下午
 * @Description TODO
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced  // 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
