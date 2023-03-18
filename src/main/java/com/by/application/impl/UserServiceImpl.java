package com.by.application.impl;

import com.by.application.UserService;
import com.by.controller.vo.LoginRequest;
import com.by.controller.vo.LoginUserResult;
import com.by.repository.mapper.UserMapper;
import com.by.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginUserResult login(LoginRequest request) {
        LoginUserResult result = new LoginUserResult();
        try {
            User u = userMapper.getUserByName(request.getUsername());
            System.out.println(u.toString());
            result.setCode(0);
            result.setMessage("success");
        } catch (Exception e) {
            System.err.println(e);
            result.setCode(500);
            result.setMessage(e.toString());
        }

        return result;
    }
}
