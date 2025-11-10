package com.realtimechat.controller;

import com.realtimechat.config.rabbitmq.MessageProducer;
import com.realtimechat.config.rabbitmq.data.QueueData;
import com.realtimechat.config.rabbitmq.init.BindingInit;
import com.realtimechat.config.rabbitmq.init.ExchangeInit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/message-controller")
public class MessageController {
    private final MessageProducer messageProducer;

    @PostMapping("/send-message")
    ResponseEntity<String> sendMessage(@RequestBody QueueData message){
        messageProducer.sendMessage(
                ExchangeInit.MESSAGE_EXCHANGE,
                BindingInit.MESSAGE_ROUTING_KEY,
                message
        );
        return ResponseEntity.ok("Message sent successfully :"+message);
    }
}
