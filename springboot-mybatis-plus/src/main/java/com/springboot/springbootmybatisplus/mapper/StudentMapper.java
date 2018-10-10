package com.springboot.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.springbootmybatisplus.entity.Student;
import org.apache.ibatis.annotations.Param;
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
     *
     * @param id
     * @return
     */
    int updateMy (int id);

    /**
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param name 姓名
     * @return 分页对象
     */
    IPage<Student> selectPageVo(Page page, @Param("name") String name);


    /**
     * 分页测试
     *
     * @param page 分页对象
     * @param name 姓名
     * @return
     */
    IPage<Student> selectPage(Page<Student> page, @Param("name") String name);
}
