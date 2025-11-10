package com.realtimechat.config.rabbitmq.data;

import lombok.*;

import java.io.Serializable;

/**
 * Represents the payload sent to rabbitmq queues
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueData implements Serializable {

    private Integer retryCount = 0;

    private String data;


}
