package com.realtimechat.config.rabbitmq;

import com.realtimechat.config.rabbitmq.data.QueueData;
import com.realtimechat.config.rabbitmq.init.QueueInit;
import com.realtimechat.entity.Message;
import com.realtimechat.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;



    @RabbitListener(queues = QueueInit.MESSAGE_QUEUE)
    private void listenMessage(QueueData queueData) {
        log.info("Received message: {}", queueData);
        Message message = Message.builder()
                .sender("system")
                .receiver("receiver")
                .content(queueData.getData())
                .build();
        messageService.save(message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
