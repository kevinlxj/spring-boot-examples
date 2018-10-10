package com.springboot.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringbootMybatisPlusApplication class
 * 程序启动类
 *
 * @author 林星锦
 * @date 2018-10-09
 */
@SpringBootApplication
@MapperScan("com.springboot.springbootmybatisplus.mapper")
public class SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }
}
