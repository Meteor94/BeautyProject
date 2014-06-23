package com.beautyProj.service;

import com.beautyProj.dao.UserDao;

public class UserService {
    private UserDao userDao;
    
    public int userCount(){
        return userDao.getAllUser().size();
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
}
