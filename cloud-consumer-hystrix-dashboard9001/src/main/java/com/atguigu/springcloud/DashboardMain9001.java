package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @Author huang_2
 * @Date 2020/4/19 4:45 下午
 * @Description TODO
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class,args);
    }


    /**     
     *  此配置是为了服务监控而配置，与服务容错本身无观， springCloud  升级之后的坑      
     *  ServletRegistrationBean 因为 springboot 的默认路径不是 /hystrix.stream     
     *   只要在自己的项目中配置上下面的 servlet 即可      
     */
//    @Bean
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }
}
