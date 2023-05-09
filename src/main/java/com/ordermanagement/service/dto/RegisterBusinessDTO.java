package com.ordermanagement.service.dto;

import lombok.Data;

@Data
public class RegisterBusinessDTO {

    private String name;
    private String email;
    private String location;
    private String description;
    private String phoneNumber;
}
