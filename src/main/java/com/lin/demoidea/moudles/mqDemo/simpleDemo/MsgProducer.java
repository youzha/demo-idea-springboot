package com.lin.demoidea.moudles.mqDemo.simpleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * @author ljq
 * @create 2019/11/1 0001
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitTemplate rabbitTemplate;

    /**
     * 由于config配置类中rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
     * 这里用构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * @Author: ljq
     * @description: 发送消息
     * @Param: [content]
     * @Return: void
     */
    public void sendMsg(String exchange, String routingKey, String content) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队
        rabbitTemplate.convertAndSend(exchange, routingKey, content, correlationData);
    }

    /**
     * @Author: ljq
     * @description:回调函数
     * @Param: [correlationData, b, s]
     * @Return: void
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info(" 回调id:" + correlationData);
        if (b) {
            logger.info("消息成功发送");
        } else {
            logger.info("消息发送失败:" + s);
        }

    }
}
