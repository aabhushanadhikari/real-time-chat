package com.realtimechat.service.impl;

import com.realtimechat.entity.Message;
import com.realtimechat.repository.MessageRepository;
import com.realtimechat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
