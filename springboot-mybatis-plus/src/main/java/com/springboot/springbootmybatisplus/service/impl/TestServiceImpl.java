package com.springboot.springbootmybatisplus.service.impl;

import com.springboot.springbootmybatisplus.entity.Test;
import com.springboot.springbootmybatisplus.mapper.TestMapper;
import com.springboot.springbootmybatisplus.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
