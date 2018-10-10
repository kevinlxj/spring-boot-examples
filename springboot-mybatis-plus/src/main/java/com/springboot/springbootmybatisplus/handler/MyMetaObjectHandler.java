package com.springboot.springbootmybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyMetaObjectHandler class
 * 公共字段设置
 *
 * @author 林星锦
 * @date 2018-10-09
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        System.out.println(LocalDateTime.now());
        System.out.println(metaObject);
        log.info("12" + metaObject.getValue("gmtCreate"));
        this.setFieldValByName("gmtCreate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("gmtModified",LocalDateTime.now(),metaObject);
    }


}
