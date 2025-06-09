package com.repository;
import com.model.CUSTOMER_IDENTITY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
public interface CustomerIdentityRepository extends JpaRepository<CUSTOMER_IDENTITY, Integer> {
	@Query("SELECT ci FROM CUSTOMER_IDENTITY ci WHERE " +
	           "LOWER(ci.cidNum) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
	           "CAST(ci.cidCode AS string) LIKE CONCAT('%', :searchWord, '%')")
	    List<CUSTOMER_IDENTITY> searchCustomerIdentities(@Param("searchWord") String searchWord);
}
