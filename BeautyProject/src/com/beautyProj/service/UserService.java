package com.beautyProj.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beautyProj.dao.UserDao;
@Service("userService")
public class UserService {
    @Resource
    private UserDao userDao;
    
    public int userCount(){
        return userDao.getAllUser().size();
    }
}
