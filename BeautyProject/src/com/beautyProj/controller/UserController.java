package com.beautyProj.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beautyProj.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        logger.info("初始化Controller。");
        users.put("u0001", new User("admin", "admin"));
        users.put("u0002", new User("user", "user"));
        users.put("u0003", new User("user2", "user2"));
        users.put("u0004", new User("user3", "user3"));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("调用用户列表界面");
        model.addAttribute("users", users);
        return "user/list";
    }
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(Model model){
        logger.info("调取注册页面！");
        model.addAttribute(new User());
        return "user/register";
    }
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String registerEnd(@Validated User user,BindingResult br){
        if(br.hasErrors()){
            return "user/register";
        }
        users.put(user.getUsername(), user);
        return "redirect:/user/users";
    }
}
