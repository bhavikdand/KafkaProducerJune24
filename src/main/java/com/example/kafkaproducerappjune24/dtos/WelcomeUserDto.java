package com.example.kafkaproducerappjune24.dtos;

import lombok.Data;

@Data
public class WelcomeUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String from;
    private String body;
    private String subject;
}
