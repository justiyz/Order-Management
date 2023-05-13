package com.ordermanagement.service.dto;

import lombok.Data;

@Data
public class RegisterBusinessDto {

    private String name;
    private String email;
    private String location;
    private String description;
    private String phoneNumber;
}
