package com.beautyProj.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beautyProj.dao.UserDao;
import com.beautyProj.exception.UserException;
import com.beautyProj.model.Pager;
import com.beautyProj.model.User;
@Service("userService")
public class UserService {
    @Resource
    private UserDao userDao;
    public void add(User user){
        User u=userDao.getUser(user.getUsername());
        if(u!=null){
            throw new UserException("需要添加的用户已经存在！");
        }else{
            userDao.add(user);
        }
    }
    public void update(User user){
        userDao.update(user);
    }
    public void delete(int id){
        userDao.delete(id);
    }
    public User load(int id){
        return userDao.getUser(id);
    }
    public List<User> list(){
        return userDao.getAllUser();
    }
    public Pager<User> getUserPager(){
        return userDao.find();
    }
    public User login(String username,String password){
        User u=userDao.getUser(username);
        if(u == null){
            throw new UserException("登录用户不存在！");
        }else if(!u.getPassword().equals(password)){
            throw new UserException("密码不正确！");
        }else{
            return u;
        }
    }
    public int userCount(){
        return userDao.getAllUser().size();
    }
}
