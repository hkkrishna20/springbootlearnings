package com.example.demo.service;

import java.util.Optional;

import com.example.demo.domain.BankGet;

public interface Bankservice {
	BankGet savedetails (BankGet input);
	Optional<BankGet> findbyid(Long TIN_ID);
	Iterable<BankGet> allid();
}
