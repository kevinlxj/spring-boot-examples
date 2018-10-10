package com.springboot.springbootmybatisplus.util;

import com.springboot.springbootmybatisplus.entity.Result;
import com.springboot.springbootmybatisplus.entity.ResultEnum;


/**
 * ResultUtil class
 * 统一封装返回结果
 *
 * @author 林星锦
 * @date 2018-10-09
 */
public class ResultUtil {

    /**
     * 成功且带数据
     *
     * @param object 对象
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 成功但不带数据
     *
     * @return Result
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 失败
     * @param code 错误码
     * @param msg 错误信息
     * @return Result
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

