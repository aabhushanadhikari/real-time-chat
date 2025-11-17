package com.realtimechat.service.impl;

import com.realtimechat.dto.UserSignupRequestDto;
import com.realtimechat.entity.auth.User;
import com.realtimechat.repository.UserRepository;
import com.realtimechat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserSignupRequestDto userSignupRequestDto) {
        if(userRepository.existsByUsername(userSignupRequestDto.getUsername())) throw new RuntimeException("Username already exists");
        User user =new User();
        user.setUsername(userSignupRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(userSignupRequestDto.getPassword()));
        userRepository.save(user);
    }
}
