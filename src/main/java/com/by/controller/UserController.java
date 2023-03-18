package com.by.controller;

import com.by.application.UserService;
import com.by.controller.vo.LoginRequest;
import com.by.controller.vo.LoginUserResult;
import com.by.repository.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource(name="userServiceImpl")
    private UserService userService;

    @PostMapping("/login")
    public LoginUserResult login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

}
