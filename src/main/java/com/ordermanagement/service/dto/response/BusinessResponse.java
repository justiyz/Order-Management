package com.ordermanagement.service.dto.response;

import com.ordermanagement.data.model.business.Business;
import lombok.Data;

import java.util.List;

@Data
public class BusinessResponse {
    private List<Business> totalBusinesses;
    private long noOfTotalBusinesses;
    private Integer noOfTotalPages;
    private Integer currentPage;
    private Integer pageSize;
}
