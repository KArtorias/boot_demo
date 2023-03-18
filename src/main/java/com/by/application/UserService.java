package com.by.application;

import com.by.controller.vo.LoginRequest;
import com.by.controller.vo.LoginUserResult;

public interface UserService {
    LoginUserResult login(LoginRequest request);
}
