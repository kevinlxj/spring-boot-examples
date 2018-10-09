package com.springboot.springbootmybatisplus.controller;


import com.springboot.springbootmybatisplus.entity.Test;
import com.springboot.springbootmybatisplus.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxj
 * @since 2018-09-30
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("insert")
    public Boolean insert(){
        Test test = new Test();
        test.setAa("aa");
        test.setBb("bb");
        System.out.println(test);
        return testService.save(test);
    }

    @GetMapping("update")
    public Boolean update(){
        Test test = new Test();
        test.setId(2);
        test.setAa("123");
        test.setBb("123");
        System.out.println(test);
        return testService.updateById(test);
    }

    @GetMapping("/500")
    public int test500(){
        int a = 5/0;
        return  a;
    }

}
