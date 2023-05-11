package com.ordermanagement.service.business;

import com.ordermanagement.data.model.business.Business;
import com.ordermanagement.data.repository.business.BusinessRepository;
import com.ordermanagement.service.dto.RegisterBusinessDTO;
import com.ordermanagement.service.dto.response.BusinessResponse;
import com.ordermanagement.web.exception.OrderManagementException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public BusinessResponse findAllBusinesses(int pageNumber, int pageSize) {
        BusinessResponse response = new BusinessResponse();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Business> pagedResult = businessRepository.findAll(pageable);
        response.setNoOfTotalBusinesses(pagedResult.toList().size());
        response.setNoOfTotalPages(pagedResult.getTotalPages());
        response.setTotalBusinesses(pagedResult.toList());
        response.setCurrentPage(pageNumber);
        response.setPageSize(pageSize);
        return response;
    }
}
