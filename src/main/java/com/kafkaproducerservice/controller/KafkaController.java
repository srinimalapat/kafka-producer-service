package com.kafkaproducerservice.controller;

import com.kafkaproducerservice.model.Message;
import com.kafkaproducerservice.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/publish")
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Message message) {
        producerService.sendMessage(message);
        log.info("Message has been published ----->>>>> message: "+message);
        return ResponseEntity.ok("Message has been published ----->>>>> message: "+message);
    }
}
