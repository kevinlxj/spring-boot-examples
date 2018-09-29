package com.springboot.springbootmybatisplus.mapper;

import com.springboot.springbootmybatisplus.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxj
 * @since 2018-09-29
 */
@Component
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 自定义修改的sql
     * @param 实体对象
     * @return
     */
    int updateMy (int id);
}
