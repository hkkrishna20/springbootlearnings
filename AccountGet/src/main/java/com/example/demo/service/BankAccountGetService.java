package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.BankGet;

@FeignClient(name = "BankAccount", url = "http://localhost:8089")

public interface BankAccountGetService {
	
	@RequestMapping(value = "/company/{tin}", method = RequestMethod.GET)
	Optional<BankGet> findbyid(@PathVariable(value = "tin") Long tin);
	
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	Iterable<BankGet> allid();
	
	@RequestMapping(value = "/company/{tin}" , method = RequestMethod.DELETE)
	public void deletebyid(Long tin);
}
