package com.beautyProj.controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beautyProj.model.User;
import com.beautyProj.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Transactional
    @RequestMapping(value = {"/users","/"}, method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("调用用户列表界面");
        
        model.addAttribute("pagers", userService.getUserPager());
        return "user/list";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("调取注册页面！");
        model.addAttribute(new User());
        return "user/register";
    }
    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult br) {
        logger.info("用户提交注册的用户信息！");
        if(br.hasErrors()){
            return "user/register";
        }else{
            System.out.println(user.getUsername()+"   "+user.getPassword()+"   "+user.getEmail());
            userService.add(user);
            return "redirect:/user/users";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable String id, Model model) {
        logger.info("查看用户资料");
        User u=userService.load(Integer.parseInt(id));
        model.addAttribute(u);
        return "user/show";
    }
    @Transactional
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String updateUser(@PathVariable String id, Model model) {
        logger.info("调取用户资料编辑页面");
        User u=userService.load(Integer.parseInt(id));
        model.addAttribute(u);
        return "user/update";
    }
    @Transactional
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateUser(@PathVariable String id, @Validated User user, BindingResult br) {
        logger.info("更新用户资料提交信息");
        user.setId(Integer.parseInt(id));
        userService.update(user);
        return "redirect:/user/users";
    }
    @Transactional
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        logger.info("删除用户信息！用户ID："+id);
        userService.delete(Integer.parseInt(id));
        return "redirect:/user/users";
    }
}
