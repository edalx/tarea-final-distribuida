package com.eacuji.mq;

import com.eacuji.email.EmailService;
import com.eacuji.email.SenderNotify;
import com.eacuji.entities.Instrument;
import com.eacuji.services.SingerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsumerConfig {

    @Autowired
    private SenderNotify senderNotify;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(Instrument instrument) {
        senderNotify.sender(instrument.getInstrumentId());
        System.out.println("Recieved Instrument: " + instrument);
    }
}