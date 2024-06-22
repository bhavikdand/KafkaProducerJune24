package com.example.kafkaproducerappjune24.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDto {

    private String firstName;
    private String lastName;
    private String email;
}
