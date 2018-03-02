package com.eacuji.mq;

import com.eacuji.entities.Instrument;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ProducerConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    public void sendMessage(Instrument instrument) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(exchange, routingKey, instrument);
        System.out.println(":"+instrument);
    }
}