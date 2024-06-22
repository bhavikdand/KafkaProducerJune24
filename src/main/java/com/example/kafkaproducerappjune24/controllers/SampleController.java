package com.example.kafkaproducerappjune24.controllers;

import com.example.kafkaproducerappjune24.configs.KafkaProducer;
import com.example.kafkaproducerappjune24.dtos.CreateUserRequestDto;
import com.example.kafkaproducerappjune24.dtos.WelcomeUserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class SampleController {

    private KafkaProducer kafkaProducer;
    private ObjectMapper objectMapper;

    public SampleController(KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/")
    public void sampleApi(@RequestBody CreateUserRequestDto requestDto) throws JsonProcessingException {

        WelcomeUserDto userDto = new WelcomeUserDto();
        userDto.setFirstName(requestDto.getFirstName());
        userDto.setLastName(requestDto.getLastName());
        userDto.setEmail(requestDto.getEmail());
        userDto.setFrom("admin@scaler.com");
        userDto.setSubject("Welcome to Scaler!");
        userDto.setBody("All the best fro the journey!");

        String message = objectMapper.writeValueAsString(userDto);

        kafkaProducer.send("sendEmail", message);
    }

}
