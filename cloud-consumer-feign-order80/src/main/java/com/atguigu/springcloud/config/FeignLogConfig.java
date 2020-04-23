package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huang_2
 * @Date 2020/4/19 12:20 下午
 * @Description TODO
 */
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        //  请求和响应的头信息 , 请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
