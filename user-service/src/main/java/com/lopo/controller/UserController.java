package com.lopo.controller;


import com.lopo.domain.User;
import com.lopo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String list(){
        return "user list";
    }

    @GetMapping("/{userId}")
    public User detail(@PathVariable String userId){
        return userService.getById(userId);
    }
}
