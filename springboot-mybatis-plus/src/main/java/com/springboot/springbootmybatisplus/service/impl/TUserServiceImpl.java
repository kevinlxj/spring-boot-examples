package com.springboot.springbootmybatisplus.service.impl;

import com.springboot.springbootmybatisplus.entity.TUser;
import com.springboot.springbootmybatisplus.mapper.TUserMapper;
import com.springboot.springbootmybatisplus.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lxj
 * @since 2018-09-29
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
