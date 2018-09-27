package com.springbootdemo.springbootmybatisxml.mapper;

import com.springbootdemo.springbootmybatisxml.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserMapper {

    List<User> findUserAll();

    User findUserById(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

}
