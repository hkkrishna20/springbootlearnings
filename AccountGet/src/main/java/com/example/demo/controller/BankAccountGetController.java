package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.domain.Bank;
import com.example.demo.domain.BankGet;
import com.example.demo.service.BankAccountGetService;

@RefreshScope
@RestController
public class BankAccountGetController {

	@Autowired
	private BankAccountGetService bankAccountGetService ;
	
//	@GetMapping("/get/{tin}")
//	public ResponseEntity<?> findbyid(@PathVariable Long tin){
//		System.out.println("sdsdsd");
//		return ResponseEntity.ok(bankAccountGet.findbyid(tin));
//	}
	
	@GetMapping("/company1/{tin}")
	public ResponseEntity<Optional<BankGet>> findbyid(@PathVariable("tin") Long tin){
		Optional<BankGet> result1 = bankAccountGetService.findbyid(tin);
		return new ResponseEntity<>(result1 ,HttpStatus.OK);
	}
	
	
	@GetMapping("/company1")
	public ResponseEntity<Iterable<BankGet>> allid(){
		Iterable<BankGet> result1 = bankAccountGetService.allid();
		return new ResponseEntity<>(result1 , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/company/{tin}")
	public void deletebyid(Long tin) {
		bankAccountGetService.deletebyid(tin);
	}
//	@GetMapping("/fetchProduct/{tin}")
//	 public ResponseEntity<BankGet> findbyid(@PathVariable Long tin) {
//
//	  return ResponseEntity.ok(bankAccountGet.findbyid(tin));
//	 }

}
