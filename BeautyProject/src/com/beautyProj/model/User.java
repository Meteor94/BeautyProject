package com.beautyProj.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FID")
    private Integer id;

    @Column(name = "FUSERNAME", length = 20)
    private String username;

    @Column(name = "FPASSWORD", length = 20)
    private String password;

    @Column(name = "FEMAIL", length = 200)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "用户名不能为空")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 1, max = 20, message = "密码长度为1-20之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", user_name=" + username + ", password=" + password + ", email=" + email + "]";
    }
}
