package com.example.demo.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "bankget")
public class BankGet {
	@Id
	private Long TIN_ID;
	private String[] CompanyName;

	public BankGet() {
		super();
	}

	public BankGet(Long tIN_ID, String[] companyName) {
		super();
		TIN_ID = tIN_ID;
		CompanyName = companyName;
	}

	public Long getTIN_ID() {
		return TIN_ID;
	}

	public void setTIN_ID(Long tIN_ID) {
		TIN_ID = tIN_ID;
	}

	public String[] getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String[] companyName) {
		CompanyName = companyName;
	}

	@Override
	public String toString() {
		return "BankGet [TIN_ID=" + TIN_ID + ", CompanyName=" + Arrays.toString(CompanyName) + "]";
	}

}
