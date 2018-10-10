package com.springboot.springbootmybatisplus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @desc 123123
 * @author 林星锦
 * @date 2018/10/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;
}
