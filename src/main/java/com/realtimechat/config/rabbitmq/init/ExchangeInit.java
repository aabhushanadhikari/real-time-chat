package com.realtimechat.config.rabbitmq.init;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Init class to initialize exchange
 */
@Configuration
public class ExchangeInit {
    public static final String MESSAGE_EXCHANGE="message_exchange";

    @Bean
    public TopicExchange messageExchange(){return new TopicExchange(MESSAGE_EXCHANGE);}
}
