package shizuka.infrastructure.mq.consumer.handler;

import org.springframework.stereotype.Component;
import shizuka.infrastructure.mq.consumer.SimpleConsumer;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 16:34
 */
@Component
public class TestConsumer implements SimpleConsumer {
    @Override
    public void execute(String message) {
        System.out.println("接收到消息"+message);
    }
}
