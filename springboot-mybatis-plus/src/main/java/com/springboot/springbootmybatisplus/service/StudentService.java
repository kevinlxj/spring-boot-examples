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

    /**
     * @desc 12312312312
     * @param id	
     * @return int
     * @author 林星锦
     * @date 2018/10/10
     * @update 
     */
    int updateMy (int id);

    /**
     * @desc 12213123
     * @param page
     * @param name
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.springboot.springbootmybatisplus.entity.Student>
     * @author 林星锦
     * @date 2018/10/10
     * @update
     */
    IPage<Student> selectPageVo(Page page, @Param("name") String name);

}
