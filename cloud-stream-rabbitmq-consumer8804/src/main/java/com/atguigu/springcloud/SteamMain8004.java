package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author huang_2
 * @Date 2020/4/20 1:37 下午
 * @Description TODO
 */
@EnableEurekaClient
@SpringBootApplication
public class SteamMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(SteamMain8004.class,args);
    }
}
