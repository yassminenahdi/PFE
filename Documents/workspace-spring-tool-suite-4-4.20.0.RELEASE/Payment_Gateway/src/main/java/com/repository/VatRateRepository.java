package com.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.*;

public interface VatRateRepository extends JpaRepository<VatRate, Integer> {
	VatRate findByVatCodeAndVatActive(Integer vatCode, Integer vatActive);
	
	
	

}
