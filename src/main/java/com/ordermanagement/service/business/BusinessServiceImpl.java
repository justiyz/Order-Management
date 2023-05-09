package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{
    @Override
    public void registerBusiness(RegisterBusinessDTO dto) {

    }

    @Override
    public void findBusinessById(String businessId) {

    }

    @Override
    public List<Business> findAllBusiness() {
        return null;
    }
}
