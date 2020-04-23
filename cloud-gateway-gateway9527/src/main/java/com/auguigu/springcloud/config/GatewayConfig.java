package com.auguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huang_2
 * @Date 2020/4/19 6:59 下午
 * @Description TODO
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_test",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_test2",r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
