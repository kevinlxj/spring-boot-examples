package com.springboot.springbootmybatisplus.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * MyBatisPlusConfig class
 * MyBatisPlus配置类
 *
 * @author 林星锦
 * @date 2018-10-09
 */
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    /**
     * SQL 执行性能分析，开发环境使用，线上不推荐
     * @Profile({"dev","test"})
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        ///SQL 执行最大时长，超过自动停止运行，有助于发现问题。单位：ms, 自行设置，此处设置为30s
        //performanceInterceptor.setMaxTime(30*1000);
        //SQL 是否格式化
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return new PaginationInterceptor();
    }

}
