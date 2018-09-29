package com.springboot.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.springbootmybatisplus.entity.Student;
import com.springboot.springbootmybatisplus.mapper.StudentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Student> studentList = studentMapper.selectList(null);
        Assert.assertEquals(19,studentList.size());
        studentList.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        System.out.println("---testSelectById---");
        Student student = studentMapper.selectById(19);
        System.out.println(student);
    }

    @Test
    public void testSelectOne() {
        System.out.println("---testSelectOne---");
        //QueryWrapper queryWrapper = new QueryWrapper();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
//        EntityWrapper<Student> wrapper = new EntityWrapper<>();
        wrapper.eq("name", "王杨帅").last("limit 1");
//        List<Student> studentList = studentMapper.selectList(wrapper);
        Student studentList = studentMapper.selectOne(wrapper);
//        studentMapper.
        System.out.println(studentList);
//        studentList.forEach(System.out::println);
    }

}
