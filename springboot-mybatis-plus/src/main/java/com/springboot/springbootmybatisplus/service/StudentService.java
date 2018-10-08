package com.springboot.springbootmybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.springbootmybatisplus.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxj
 * @since 2018-09-29
 */
public interface StudentService extends IService<Student> {

    int updateMy (int id);

    IPage<Student> selectPageVo(Page page, @Param("name") String name);

}
