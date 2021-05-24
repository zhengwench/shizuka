package shizuka.infrastructure.application;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shizuka.infrastructure.mq.consumer.ConsumerConfig;
import shizuka.infrastructure.mq.consumer.SpringRabbitmqConsumerListener;
import shizuka.infrastructure.mq.consumer.handler.AConsumer;
import shizuka.infrastructure.mq.consumer.handler.TestConsumer;
import shizuka.infrastructure.mq.producer.SpringRabbitmqProducer;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-31 15:50
 */
@Configuration
public class RabbitmqConfig {

    @Value("${analyseConsumer.config.queueName}")
    private String queueName;

    @Value("${analyseConsumer.config.exchangeName}")
    private String exchangeName;

    @Value("${analyseConsumer.config.exchangeType}")
    private String exchangeType = "direct";

    @Value("${analyseConsumer.config.routingKey}")
    private String routingKey;

    @Value("${analyseConsumer.config.durable}")
    private Boolean durable;

    @Value("${analyseConsumer.config.prefetchCount}")
    private Integer prefetchCount = 20;

    @Autowired
    private TestConsumer testConsumer;

    @Autowired
    private AConsumer aConsumer;

    @Bean
    public SpringRabbitmqProducer springRabbitmqProducer(){
        SpringRabbitmqProducer springRabbitmqProducer = new SpringRabbitmqProducer();
        return springRabbitmqProducer;
    }

    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setExchangeName(exchangeName);
        consumerConfig.setExchangeType(exchangeType);
        consumerConfig.setDurable(durable);
        consumerConfig.setQueueName(queueName);
        consumerConfig.setRoutingKey(routingKey);
        return consumerConfig;
    }

//    @Bean(initMethod = "init",name = "firstRabbitMqConsumer")
//    @ConditionalOnExpression("'${analyseConsumer.count}' > '0'")
    public SpringRabbitmqConsumerListener firstRabbitMqConsumer(ConsumerConfig consumerConfig, ConnectionFactory connectionFactory){
        return new SpringRabbitmqConsumerListener("firstRabbitMqConsumer",consumerConfig,testConsumer,connectionFactory);
    }

//    @Bean(initMethod = "init",name = "secondRabbitMqConsumer")
//    @ConditionalOnExpression("'${analyseConsumer.consumerCount}' > '1'")
    public SpringRabbitmqConsumerListener secondRabbitMqConsumer(ConsumerConfig consumerConfig,ConnectionFactory connectionFactory){
        return new SpringRabbitmqConsumerListener("secondRabbitMqConsumer",consumerConfig,aConsumer, connectionFactory);
    }
}
