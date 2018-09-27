package com.springbootdemo.springbootmybatisxml.service;


import com.springbootdemo.springbootmybatisxml.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUserAll();

    User findUserById(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

}
