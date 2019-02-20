package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bank")
public class Bank {
	@Id
	private Long tin;
	@Column
	private String[] companyName;

	public Long getTin() {
		return tin;
	}

	public void setTin(Long tin) {
		this.tin = tin;
	}

	public String[] getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String[] companyName) {
		this.companyName = companyName;
	}

	public Bank(Long tin, String[] companyName) {
		super();
		this.tin = tin;
		this.companyName = companyName;
	}

	public Bank() {
		super();
	}

	
}
