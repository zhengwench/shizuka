package shizuka.infrastructure.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 16:44
 */
@Slf4j
public class SpringRabbitmqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String exchange,String routingKey,String msg) {
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
    }
}
