package com.springboot.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxj
 * @since 2018-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省份编号
     */
    private Integer province_id;

    /**
     * 城市名称
     */
    private String city_name;

    /**
     * 描述
     */
    private String description;


}
