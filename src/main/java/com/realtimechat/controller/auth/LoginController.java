package com.realtimechat.controller.auth;

import com.realtimechat.dto.UserLoginRequestDto;
import com.realtimechat.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class LoginController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@Valid UserLoginRequestDto userLoginRequestDto){
        return authService.authenticateUser(userLoginRequestDto);
    }
}
