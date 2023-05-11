package com.ordermanagement.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderDTO {

    private String orderDate;
    private String orderStatus;
    private List<ItemsDTO> items;
    private String customerPhoneNumber;
}
