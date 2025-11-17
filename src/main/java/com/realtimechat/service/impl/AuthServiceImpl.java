package com.realtimechat.service.impl;

import com.realtimechat.config.auth.jwtconfig.JwtUtil;
import com.realtimechat.dto.UserLoginRequestDto;
import com.realtimechat.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public String authenticateUser(UserLoginRequestDto userLoginRequestDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequestDto.getUsername(),
                        userLoginRequestDto.getPassword()
                )
        );
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();

        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
