package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDTO;

import java.util.List;

public interface BusinessService {

    void registerBusiness(RegisterBusinessDTO dto);
    void findBusinessById(String businessId);
    List<Business> findAllBusiness();
}
