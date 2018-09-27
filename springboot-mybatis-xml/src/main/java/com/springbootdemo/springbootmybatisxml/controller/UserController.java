package com.springbootdemo.springbootmybatisxml.controller;

import com.springbootdemo.springbootmybatisxml.entity.User;
import com.springbootdemo.springbootmybatisxml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/findUserAll")
    public List<User> findUserAll() {
        System.out.println("333");
        return userService.findUserAll();
    }

    @GetMapping("/api/findUserById")
    public User findUserById(@RequestParam(value = "id", required = true) Integer id) {
        System.out.println("2222");
        return userService.findUserById(id);
    }

    @GetMapping("/api/insertUser")
    public int insertUser() {
        System.out.println("333");
        User user = new User();
        user.setUsername("abcd");
        user.setName("小明");
        user.setPassword("aaa");
        user.setPhone("123456789");
        user.setStatus(1);
        user.setUpdatedTime(new Date());
        user.setCreatedTime(new Date());
        return userService.insertUser(user);
    }

    //?username=123&password=2323&name=中国&phone=11111&status=0&id=4
    @GetMapping("/api/updateUser")
    public int updateUser(@RequestParam(value = "id", required = true) Integer id,
                          @RequestParam(value = "username", required = false) String username,
                          @RequestParam(value = "password", required = false) String password,
                          @RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "phone", required = false) String phone,
                          @RequestParam(value = "status", required = false) Integer status) {
        System.out.println("updateUser");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setStatus(status);
        System.out.println(user);
        return userService.updateUser(user);
    }

    @GetMapping("/api/deleteUser")
    public int deleteUser(@RequestParam("id") Integer id) {
        System.out.println("deleteUser");
        return userService.deleteUser(id);
    }

}
