package com.springbootdemo.springbootmybatisxml.entity;

import java.util.Date;

public class User {

    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 名字
     */
    private String password;

    /**
     * 账号
     */
    private String name;
    /**
     * md5密码盐
     */
    private String phone;

    /**
     * 状态 1:正常 2:禁用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }


    /**
     * 在类中如果我们没有重写ToString方法。默认就是Object的toString方法输出格式。
     * 如果重写了toString方法，那么输出格式就会按照我们定义的方式输出这个对象
     * @return
     */
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", status=" + status + "]";
    }
}
