package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.service.dto.response.BusinessResponse;
import com.ordermanagement.web.exception.OrderManagementException;

import java.util.List;

public interface BusinessService {

    void registerBusiness(RegisterBusinessDTO dto);
    Business findBusinessById(int businessId) throws OrderManagementException;
    BusinessResponse findAllBusinesses(int pageNumber, int pageSize);
}
