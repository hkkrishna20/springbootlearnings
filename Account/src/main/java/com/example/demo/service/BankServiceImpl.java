package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Bank;
import com.example.demo.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankRepository bankRepository;
	
	
	
	
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
//	
//	@Override
//	public Bank savedetails(Bank input) {
//		return bankRepository.save(input);
//	}
	
	@Override
	public Bank savedetails(Bank input) {
		Bank result = new Bank();
		if (bankRepository.existsById(input.getTin()) == true) {
			Optional<Bank> a = bankRepository.findById(input.getTin());
			String[] y = a.get().getCompanyName();
			List<String> bank1 = Arrays.asList(y);
			String[] b = input.getCompanyName();
			List<String> bank2 = new ArrayList<>();
			for (String q : b) {
				bank2.add(q);
			}
			Set<String> banks = new HashSet<String>();
			banks.addAll(bank1);
			banks.addAll(bank2);
			Bank c = new Bank();
			c.setCompanyName(banks.toArray(new String[0]));
			c.setTin(input.getTin());

			result = bankRepository.save(c);

		} else {
			result = bankRepository.save(input);
		}

		return result;
	}
	
	@Override
	public Optional<Bank> findbyid(Long tin){
		return bankRepository.findById(tin);
	}
	
	
	@Override
	public void deletebyid(Long tin){
		bankRepository.deleteById(tin);
	}
	
	@Override
	public Iterable<Bank> allid(){
		return bankRepository.findAll();
	}
	
//	@Override
//	public Bank updatebyid(Bank input) {
//		if(bankRepository.existsById(input.getTin())) {
//			List<Bank> banks = new ArrayList<>();
//			for(Bank m : allid()) {
//				banks.add(m);
//			}
//			banks.add(input.setCompanyName(input.getCompanyName()));
//		}
//		
//		return ;
//	}
	
	@Override
	public Bank updatebyid(Bank input) {
		Bank result = new Bank();
		if(bankRepository.existsById(input.getTin())) {
			Bank c = new Bank();
			c.setTin(input.getTin());
			c.setCompanyName(input.getCompanyName());
			result = bankRepository.save(c);
		}
		return result;
	}
}
