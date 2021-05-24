package shizuka.infrastructure.mq.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.io.IOException;
import java.util.UUID;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 16:09
 */
@Slf4j
public class SpringRabbitmqConsumerListener {

    private ConnectionFactory connectionFactory;

    private String consumerId;

    private SimpleConsumer simpleConsumer;

    private ConsumerConfig consumerConfig;

    public SpringRabbitmqConsumerListener(ConsumerConfig consumerConfig,SimpleConsumer simpleConsumer,ConnectionFactory connectionFactory){
        if (consumerConfig == null){
            throw new RuntimeException("消费者配置为空");
        }
        if (simpleConsumer == null){
            throw new RuntimeException("消费者执行器为空");
        }
        this.consumerConfig = consumerConfig;
        this.simpleConsumer = simpleConsumer;
        this.connectionFactory = connectionFactory;
        this.consumerId = UUID.randomUUID().toString();
    }

    public SpringRabbitmqConsumerListener(String consumerId,ConsumerConfig consumerConfig,SimpleConsumer simpleConsumer,ConnectionFactory connectionFactory){
        if (consumerConfig == null){
            throw new RuntimeException("消费者配置为空");
        }
        if (simpleConsumer == null){
            throw new RuntimeException("消费者执行器为空");
        }
        this.consumerConfig = consumerConfig;
        this.simpleConsumer = simpleConsumer;
        this.connectionFactory = connectionFactory;
        if (StringUtils.isEmpty(consumerId)){
            this.consumerId = UUID.randomUUID().toString();
        }else {
            this.consumerId = consumerId;
        }

    }

    public void init(){
        try {
            log.info("开启 RabbitmqConsumer {}", consumerConfig.toString());
            connectionFactory.createConnection();
            Connection connection = connectionFactory.createConnection().getDelegate();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(consumerConfig.getExchangeName(), consumerConfig.getExchangeType(), consumerConfig.getDurable());
            channel.queueDeclare(consumerConfig.getQueueName(), consumerConfig.getDurable(), false, false, null);
            channel.queueBind(consumerConfig.getQueueName(), consumerConfig.getExchangeName(), consumerConfig.getRoutingKey());
            channel.basicQos(consumerConfig.getPrefetchCount());
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    log.info("consumer[{}]received message ->{}",consumerId,message);
                    try {
                        simpleConsumer.execute(message);
                    } catch (Exception e) {
                        log.error("consumer execute message error msg->{}",message,e);
                    }
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            channel.basicConsume(consumerConfig.getQueueName(), false, consumer);
        } catch (Exception ex) {
            log.error("SpringRabbitmqConsumerListener error",consumerConfig.toString());
        }
    }
}
