package com.realtimechat.config.rabbitmq.init;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Init class to initialize queue
 */
@Configuration
public class QueueInit {
    public static final String MESSAGE_QUEUE="message_queue";

    @Bean
    public Queue messageQueue(){return new Queue(MESSAGE_QUEUE);}
}
