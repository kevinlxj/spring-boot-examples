package com.springboot.springbootmybatisplus.config;


import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
//@MapperScan("com.springboot.springbootmybatisplus.mapper")
public class MyBatisPlusConfig {

    @Bean
//    @Profile({"dev","test"})
    //SQL 执行性能分析，开发环境使用，线上不推荐
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //SQL 执行最大时长，超过自动停止运行，有助于发现问题。单位：ms, 此处设置为30s
        performanceInterceptor.setMaxTime(30*1000);
        //SQL 是否格式化
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }

}
