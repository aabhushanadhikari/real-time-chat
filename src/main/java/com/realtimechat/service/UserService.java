package com.realtimechat.service;

import com.realtimechat.dto.UserSignupRequestDto;

public interface UserService {
    void saveUser(UserSignupRequestDto userSignupRequestDto);
}
