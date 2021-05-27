package shizuka.infrastructure.domainservice;

import shizuka.domain.service.push.PushService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 17:33
 */
@Component
public class PushServiceImpl implements PushService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void pushRabbitMq(String exchange, String routingKey, String msg) {
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
    }
}
