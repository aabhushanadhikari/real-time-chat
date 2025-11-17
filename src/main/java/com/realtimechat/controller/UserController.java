package com.realtimechat.controller;

import com.realtimechat.dto.UserSignupRequestDto;
import com.realtimechat.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String registerUser(@Valid UserSignupRequestDto userSignupRequestDto){
        userService.saveUser(userSignupRequestDto);
        return "User saved successfully";
    }

}
