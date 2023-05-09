package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.repository.business.BusinessRepository;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.web.exception.OrderManagementException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private ModelMapper mapper;
    @Autowired
    BusinessRepository businessRepository;


    @Override
    public void registerBusiness(RegisterBusinessDTO dto) {
        Business business = mapper.map(dto, Business.class);
        business.setCreatedDate(LocalDateTime.now().toString());
        business.setModifiedDate(LocalDateTime.now().toString());
        businessRepository.save(business);
    }

    @Override
    public Business findBusinessById(int businessId) throws OrderManagementException {
        return businessRepository.findById(businessId)
                .orElseThrow(()-> new OrderManagementException("Business not found"));
    }

    @Override
    public List<Business> findAllBusiness() {
        return businessRepository.findAll();
    }
}
