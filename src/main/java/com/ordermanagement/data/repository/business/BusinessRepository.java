package com.ordermanagement.data.repository.business;

import com.ordermanagement.data.model.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
