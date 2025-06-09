package com.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DOC_TYPE")
@Data
public class DOC_TYPE {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DTY_CODE", nullable = false, unique = true)
    private Integer dtyCode;

    @Column(name = "DTY_IDEN", nullable = false)
    private String dtyIden;

    @Column(name = "DTY_LABE", nullable = false)
    private String dtyLabe;
    
    @OneToMany(mappedBy = "docType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CUSTOMER_DOC> customerDocs;

	
	public Integer getDtyCode() {
		return dtyCode;
	}

	public void setDtyCode(Integer dtyCode) {
		this.dtyCode = dtyCode;
	}

	public String getDtyIden() {
		return dtyIden;
	}

	public void setDtyIden(String dtyIden) {
		this.dtyIden = dtyIden;
	}

	public String getDtyLabe() {
		return dtyLabe;
	}

	public void setDtyLabe(String dtyLabe) {
		this.dtyLabe = dtyLabe;
	}

	public List<CUSTOMER_DOC> getCustomerDocs() {
		return customerDocs;
	}

	public void setCustomerDocs(List<CUSTOMER_DOC> customerDocs) {
		this.customerDocs = customerDocs;
	}

	
	public DOC_TYPE(Integer dtyCode, String dtyIden, String dtyLabe, List<CUSTOMER_DOC> customerDocs) {
		super();
		this.dtyCode = dtyCode;
		this.dtyIden = dtyIden;
		this.dtyLabe = dtyLabe;
		this.customerDocs = customerDocs;
	}

	public DOC_TYPE() {}

	
    

}
