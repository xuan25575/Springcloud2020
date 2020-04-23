package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author huang_2
 * @Date 2020/4/20 1:47 下午
 * @Description TODO
 */
@RestController
public class SendController {

    @Resource
    private IMessageProvider provider;


    @GetMapping("/provider/stream/send")
    public String send(){
        provider.send();
        return "";
    }
}
