package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huang_2
 * @Date 2020/4/19 9:54 上午
 * @Description  不能被@SpringBootApplication 注解扫描，才能达到特殊化定制
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//随机
    }
}
