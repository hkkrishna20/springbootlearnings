package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BankGet;
import com.example.demo.repository.BankGetRepository;

@Service
public class  BankserviceImpl implements Bankservice{
	
	
	@Autowired
	private BankGetRepository bankGetRepository;
    public BankserviceImpl(BankGetRepository bankGetRepository) {
		this.bankGetRepository = bankGetRepository;
	}
	
	@Override
	public BankGet savedetails(BankGet input) {
		BankGet result = new BankGet();
		if (bankGetRepository.existsById(input.getTIN_ID()) == true) {
			Optional<BankGet> a = bankGetRepository.findById(input.getTIN_ID());
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
			BankGet c = new BankGet();
			c.setCompanyName(banks.toArray(new String[0]));
			c.setTIN_ID(input.getTIN_ID());

			result = bankGetRepository.save(c);

		} else {
			result = bankGetRepository.save(input);
		}

		return result;
	}
	
	@Override
	public Optional<BankGet> findbyid(Long TIN_ID){
		return bankGetRepository.findById(TIN_ID);
	}

	@Override
	public Iterable<BankGet> allid() {
		
		return bankGetRepository.findAll();
	}
	
}
