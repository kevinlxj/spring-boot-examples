package com.springboot.springbootmybatisplus.entity;


/**
 * ResultEnum class
 * 错误信息枚举类
 *
 * @author 林星锦
 * @date 2018-10-09
 */
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    USER_NOT_EXIST(1,"用户不存在"),
    USER_IS_EXISTS(2,"用户已存在"),
    DATA_IS_NULL(3,"数据为空"),
    ;
    private Integer code;
    private String msg;


    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

