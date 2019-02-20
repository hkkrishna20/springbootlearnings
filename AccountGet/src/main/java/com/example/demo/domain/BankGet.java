package com.example.demo.domain;





public class BankGet {

	private Long tin;
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
	public BankGet(Long tin, String[] companyName) {
		super();
		this.tin = tin;
		this.companyName = companyName;
	}
	public BankGet() {
		super();
	}
	
	
	
}
