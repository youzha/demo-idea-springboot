package com.lin.demoidea.config;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljq
 * @create 2019/11/1 0001
 */
@Configuration
public class RabbitMQConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    // Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
    public static final String EXCHANGE_A = "lin-mq-exchange_A";
    public static final String EXCHANGE_B = "lin-mq-exchange_B";
    public static final String EXCHANGE_C = "lin-mq-exchange_C";

    // Queue:消息的载体,每个消息都会被投到一个或多个队列。
    public static final String QUEUE_A = "LIN_QUEUE_A";
    public static final String QUEUE_B = "LIN_QUEUE_B";
    public static final String QUEUE_C = "LIN_QUEUE_C";

    // Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
    public static final String ROUTINGKEY_A = "lin_spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "lin_spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "lin_spring-boot-routingKey_C";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.SIMPLE);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_A);
    }
    @Bean
    public Queue queueA() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-queue-type", "classic");
        return new Queue(QUEUE_A, true, false, false, args); //队列持久
    }
    @Bean
    public Queue queueB() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-queue-type", "classic");
        return new Queue(QUEUE_B, true, false, false, args); //队列持久
    }

    /**
     * @Author: ljq
     * @description:将队列A绑定到交换机A
     * @Param: []
     * @Return: org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitMQConfig.ROUTINGKEY_A);
    }

    /**
     * @Author: ljq
     * @description:一个交换机可以绑定多个消息队列，将队列B绑定到交换机A
     * @Param: []
     * @Return: org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(defaultExchange()).with(RabbitMQConfig.ROUTINGKEY_B);
    }

    /**
     * @Author: ljq
     * @description: 消息消费者，对队列B进行监听
     * @Param: []
     * @Return: org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
     */
    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queueB());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("队列B接受消息 " + new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
            }
        });
        return container;
    }

}
