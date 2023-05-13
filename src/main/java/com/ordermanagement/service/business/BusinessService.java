package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDto;
import com.ordermanagement.service.dto.response.BusinessResponse;
import com.ordermanagement.web.exception.OrderManagementException;

public interface BusinessService {

    void registerBusiness(RegisterBusinessDto dto);
    Business findBusinessById(int businessId) throws OrderManagementException;
    BusinessResponse findAllBusinesses(int pageNumber, int pageSize);
}
