package com.lin.demoidea.moudles.mqDemo.simpleDemo.Controller;

import com.lin.demoidea.config.RabbitMQConfig;
import com.lin.demoidea.moudles.mqDemo.simpleDemo.MsgProducer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljq
 * @create 2019/11/1 0001
 */
@RestController
@RequestMapping("/v0.1/mq")
public class SendMsgController {

    @Autowired
    private MsgProducer producer;

    @PostMapping("")
    public void sendMsg() {
        String content = "test";
        for (int i = 0; i < 10; i++) {
            producer.sendMsg(RabbitMQConfig.EXCHANGE_A, RabbitMQConfig.ROUTINGKEY_A, content + i);
        }
    }
}
