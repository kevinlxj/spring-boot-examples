package com.springboot.springbootmybatisplus.service.impl;

import com.springboot.springbootmybatisplus.entity.City;
import com.springboot.springbootmybatisplus.mapper.CityMapper;
import com.springboot.springbootmybatisplus.service.CityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}
