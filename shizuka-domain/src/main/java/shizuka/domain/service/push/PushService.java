package shizuka.domain.service.push;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 17:31
 */
public interface PushService {
    void pushRabbitMq(String exchange,String routingKey,String msg);
}
