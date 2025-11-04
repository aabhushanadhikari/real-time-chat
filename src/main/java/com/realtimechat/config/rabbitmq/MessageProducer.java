package com.realtimechat.config.rabbitmq;

import com.realtimechat.config.rabbitmq.data.QueueData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 *This class comes first in the flow of rabbitmq amqp.
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;
/**
 * This method publishes a message to the given exchange and routing key
 * @param exchange the exchange name
 * @param routingKey the routing key
 * @param data the actual message to send
  **/
    public void sendMessage(String exchange, String routingKey, QueueData data){
      try {
          rabbitTemplate.convertAndSend(exchange,routingKey,data);
      }catch (Exception e){
          log.error("Failed to send message due to {}",e.getMessage());
      }

    }

}
