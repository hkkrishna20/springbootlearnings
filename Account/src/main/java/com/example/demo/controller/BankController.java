package com.example.demo.controller;

import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Bank;
import com.example.demo.service.BankService;


@RestController
@CrossOrigin("*")
public class BankController {
	
	private BankService bankService;
	
	@Autowired
	BankController(BankService bankService){
		this.bankService = bankService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savedetails(@RequestBody Example input) {
		System.out.println("ghghghghghghgh"+input.toString());
		Bank bank = new Bank();
		bank.setCompanyName(input.getCompanyName().split(","));
		bank.setTin(Long.parseLong(input.getTINID()) );
        Bank result = bankService.savedetails(bank);
        Example2 ex = new Example2();
        ex.setTINID(result.getTin().toString());
        ex.setCompanyName(bank.getCompanyName());
        System.out.println("hey" + ex.toString());
        return new ResponseEntity<>(ex, HttpStatus.OK);
    }
	
	@GetMapping("/company/{tin}")
	public ResponseEntity<Optional<Bank>> findbyid(@PathVariable("tin") Long tin){
		Optional<Bank> result1 = bankService.findbyid(tin);
		return new ResponseEntity<>(result1 ,HttpStatus.OK);
	}
	
	@DeleteMapping("/company/{tin}")
	public void deletebyid(@PathVariable("tin") Long tin){
		bankService.deletebyid(tin);
	}
	
	@GetMapping("/company")
	public ResponseEntity<Iterable<Bank>> allid(){
		Iterable<Bank> result = bankService.allid();
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Bank> updatebyid(@RequestBody Bank input){
		Bank result  = bankService.updatebyid(input);
		return new ResponseEntity<>(result , HttpStatus.ACCEPTED);
	}
}
