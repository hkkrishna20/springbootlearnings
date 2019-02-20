package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Bank;

public interface BankRepository extends CrudRepository<Bank , Long> {
	

}
