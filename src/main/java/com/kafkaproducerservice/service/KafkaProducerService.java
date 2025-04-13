package com.kafkaproducerservice.service;

import com.kafkaproducerservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    private final String topic = "test-topic";

    public void sendMessage(Message message) {
        kafkaTemplate.send(topic, message);
    }
}
