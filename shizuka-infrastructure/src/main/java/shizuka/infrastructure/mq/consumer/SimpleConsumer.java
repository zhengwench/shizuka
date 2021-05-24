package shizuka.infrastructure.mq.consumer;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 16:14
 */
public interface SimpleConsumer {
    void execute(String message);
}
