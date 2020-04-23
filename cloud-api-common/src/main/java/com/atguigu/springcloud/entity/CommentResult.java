package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author huang_2
 * @Date 2020/4/18 11:08 上午
 * @Description 通用返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code,String message){
        this(code,message,null);
    }

}
