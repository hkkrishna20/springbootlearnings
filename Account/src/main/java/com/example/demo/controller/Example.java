package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "TIN_ID", "CompanyName" })
public class Example {

	@Override
	public String toString() {
		return "Example [tINID=" + tINID + ", companyName=" + companyName + "]";
	}

	@JsonProperty("TIN_ID")
	private String tINID;
	@JsonProperty("CompanyName")
	private String companyName;

	public String gettINID() {
		return tINID;
	}

	public void settINID(String tINID) {
		this.tINID = tINID;
	}

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("TIN_ID")
	public String getTINID() {
		return tINID;
	}

	@JsonProperty("TIN_ID")
	public void setTINID(String tINID) {
		this.tINID = tINID;
	}

	@JsonProperty("CompanyName")
	public String getCompanyName() {
		if (companyName == null) {

			companyName = new String();
		}
		return companyName;
	}

	@JsonProperty("CompanyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}