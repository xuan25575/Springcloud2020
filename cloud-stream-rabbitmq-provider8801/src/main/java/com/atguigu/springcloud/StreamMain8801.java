package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author huang_2
 * @Date 2020/4/20 1:23 下午
 * @Description TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8801 {
    public static void main(String[] args) {

        SpringApplication.run(StreamMain8801.class,args);
    }

}
