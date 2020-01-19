package com.lin.demoidea.moudles.mqDemo.simpleDemo;

import com.lin.demoidea.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ljq
 * @create 2019/11/1 0001*/
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_A)
public class MsgReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        String str = "我已接收到队列A的消息，消息内容为：" + content;
        logger.info(str);
    }

    @RabbitHandler
    public void process(String content, Channel channel, Message message) {
        try {
            //todo

            logger.info("已接收到消息，消息内容为：" + content);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
