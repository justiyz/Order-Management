package com.ordermanagement.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderDto {

    private String orderDate;
    private String orderStatus;
    private List<ItemsDto> items;
    private String customerPhoneNumber;
}
