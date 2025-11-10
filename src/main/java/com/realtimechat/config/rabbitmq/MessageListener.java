package com.realtimechat.config.rabbitmq;

import com.realtimechat.config.rabbitmq.data.QueueData;
import com.realtimechat.config.rabbitmq.init.QueueInit;
import com.realtimechat.entity.Message;
import com.realtimechat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageListener {

    private final MessageService messageService;

    public MessageListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @RabbitListener(queues = QueueInit.MESSAGE_QUEUE)
    private void listenMessage(QueueData message){
        log.info("Received message :{}",message);
        Message message1= Message.builder()
                .sender("system")
                .receiver("reciever")
                .content(message.getData())
                .build();
        messageService.save(message1);
    }
}
