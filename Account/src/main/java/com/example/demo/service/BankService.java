package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Bank;

public interface BankService {
	 Bank savedetails (Bank input);
	 Optional<Bank> findbyid(Long tin);
	 public void deletebyid(Long tin);
	 Iterable<Bank> allid();
	 Bank updatebyid(Bank input);
}
