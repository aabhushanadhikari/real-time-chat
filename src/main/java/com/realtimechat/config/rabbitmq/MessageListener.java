package com.realtimechat.config.rabbitmq;

import com.realtimechat.config.rabbitmq.data.QueueData;
import com.realtimechat.config.rabbitmq.init.QueueInit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageListener {

    @RabbitListener(queues = QueueInit.MESSAGE_QUEUE)
    private void listenMessage(QueueData message){
        log.info("Received message :{}",message);
        // TODO: Later -> forward to WebSocket / save to DB
    }
}
