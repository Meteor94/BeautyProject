package com.beautyProj.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
    private String username;
    private String password;
    @NotEmpty(message="用户名不能为空")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min=1,max=20,message="密码长度为1-20之间")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public User() {
        super();
    }
}
