package com.beautyProj.controller;

import javax.annotation.Resource;

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
    
    @RequestMapping(value = {"/users","/"}, method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("调用用户列表界面");
        model.addAttribute("message", userService.userCount());
        return "user/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("调取注册页面！");
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult br) {
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUser(@PathVariable String username, Model model) {
        return "user/show";
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String updateUser(@PathVariable String username, Model model) {
        return "user/update";
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
    public String updateUser(@PathVariable String username, @Validated User user, BindingResult br) {
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username) {
        return "redirect:/user/users";
    }
}
