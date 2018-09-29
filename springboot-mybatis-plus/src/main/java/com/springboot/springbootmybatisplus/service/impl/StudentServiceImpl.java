package com.springboot.springbootmybatisplus.service.impl;

import com.springboot.springbootmybatisplus.entity.Student;
import com.springboot.springbootmybatisplus.mapper.StudentMapper;
import com.springboot.springbootmybatisplus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxj
 * @since 2018-09-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int updateMy(int id) {
        return studentMapper.updateMy(id);
    }
}
