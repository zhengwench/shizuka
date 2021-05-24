package shizuka.infrastructure.mq.consumer;

import lombok.Data;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 16:11
 */
@Data
public class ConsumerConfig {
    private String exchangeName;

    private String exchangeType = "direct";

    private String routingKey;

    private Boolean durable;

    private String queueName;

    private Integer prefetchCount = 20;
}
