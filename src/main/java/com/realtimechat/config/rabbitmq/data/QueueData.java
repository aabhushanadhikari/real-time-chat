package com.realtimechat.config.rabbitmq.data;

import lombok.*;

/**
 * Represents the payload sent to rabbitmq queues
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueData {

    private Integer retryCount = 0;

    private String data;


}
