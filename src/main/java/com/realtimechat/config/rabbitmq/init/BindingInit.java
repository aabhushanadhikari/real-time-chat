package com.realtimechat.config.rabbitmq.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class binds the queue with the exchange with its routing key
 */

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BindingInit {
    public static final String MESSAGE_ROUTING_KEY="message_routing_key";
    private final QueueInit queueInit;
    private final ExchangeInit exchangeInit;

    @Bean
    public Binding messageBinding(){
        return BindingBuilder
                .bind(queueInit.messageQueue())
                .to(exchangeInit.messageExchange())
                .with(MESSAGE_ROUTING_KEY);
    }
}
