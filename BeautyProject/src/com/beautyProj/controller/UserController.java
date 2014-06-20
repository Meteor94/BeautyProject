package com.beautyProj.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        logger.info("初始化Controller。");
        users.put("admin", new User("admin", "admin"));
        users.put("user", new User("user", "user"));
        users.put("user2", new User("user2", "user2"));
        users.put("user3", new User("user3", "user3"));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("调用用户列表界面");
        for (Iterator iterator = users.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            User u = users.get(key);
            System.out.println(key + " " + u.getUsername() + " " + u.getPassword());
        }
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("调取注册页面！");
        model.addAttribute(new User());
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "user/register";
        }
        users.put(user.getUsername(), user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUser(@PathVariable String username, Model model) {
        System.out.println(username);
        if (users.get(username) == null) {
            System.out.println("从MAP中取出用户名为" + username + "的用户对象User为空");
        }
        model.addAttribute(users.get(username));
        return "user/show";
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String updateUser(@PathVariable String username, Model model) {
        model.addAttribute(users.get(username));
        return "user/update";
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
    public String updateUser(@PathVariable String username, @Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "user/update";
        }
        users.put(username, user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username) {
        users.remove(username);
        return "redirect:/user/users";
    }
}
