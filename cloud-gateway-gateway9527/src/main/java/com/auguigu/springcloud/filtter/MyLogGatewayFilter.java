package com.auguigu.springcloud.filtter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author huang_2
 * @Date 2020/4/19 7:13 下午
 * @Description TODO
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    /**
     * 过滤参数
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String uname = request.getQueryParams().getFirst( "uname" );
        if(uname == null){
            log.info( " 用户名为 null ，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //放行。
        return chain.filter(exchange);

    }


    /**
     * 过滤器加载的顺序越小 , 优先级别越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
