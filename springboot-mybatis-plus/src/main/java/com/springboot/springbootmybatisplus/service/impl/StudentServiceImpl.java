package com.springboot.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<Student> selectPageVo(Page page, String name) {
         ///使用说明
         /*不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
         page.setOptimizeCountSql(false);
         当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
         要点!! 分页返回的对象与传入的对象是同一个*/
        return studentMapper.selectPageVo(page, name);
    }

}
