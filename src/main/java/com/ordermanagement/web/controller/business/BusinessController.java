package com.ordermanagement.web.controller.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.business.BusinessServiceImpl;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.web.response.ResponseDetails;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessServiceImpl;

    @PostMapping
    public ResponseEntity<?> registerBusiness(@RequestBody RegisterBusinessDTO dto) {
        businessServiceImpl.registerBusiness(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Your business has been created successfully", HttpStatus.OK.toString());
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }
}
