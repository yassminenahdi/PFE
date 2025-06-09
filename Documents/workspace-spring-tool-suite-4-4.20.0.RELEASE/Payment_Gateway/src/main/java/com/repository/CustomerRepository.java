package com.repository;
import com.model.CUSTOMER;
import com.model.WALLET;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<CUSTOMER, Integer>{
	Optional<CUSTOMER> findByCusMailAddress(String email);

    Optional<CUSTOMER> findByCusPhoneNbr(String phone);

    List<CUSTOMER> findByCity_CtyCode(Integer cityCode);

    List<CUSTOMER> findByCity_Country_CtrCode(Integer countryCode);

    List<CUSTOMER> findByWalletsIsNotEmpty();

    List<CUSTOMER> findByWalletsIsEmpty();
    


    @Query("SELECT c FROM CUSTOMER c WHERE " +
            "LOWER(c.cusFirstName) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusMidName) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusLastName) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusMailAddress) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusMotDePasse) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusPhoneNbr) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusAddress) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "LOWER(c.cusIden) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR " +
            "CAST(c.cusFinId AS string) LIKE CONCAT('%', :searchWord, '%') OR " +
            "CAST(c.cusCode AS string) LIKE CONCAT('%', :searchWord, '%')")
     List<CUSTOMER> searchCustomers(@Param("searchWord") String searchWord);
    
    
    
}
