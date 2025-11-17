package com.realtimechat.service;

import com.realtimechat.dto.UserLoginRequestDto;

public interface AuthService {
    String authenticateUser(UserLoginRequestDto userLoginRequestDto);
}
