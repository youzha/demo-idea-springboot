package com.lin.demoidea.moudles.mqDemo.simpleDemo;

import com.lin.demoidea.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
}
