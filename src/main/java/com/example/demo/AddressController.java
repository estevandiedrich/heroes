package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address2")
public class AddressController{
	@Autowired
	public AddressesRepository repo;
	@PostMapping
	public ResponseEntity<Address> save(@RequestBody Address address){
		Address ret = this.repo.save(address);
		return ResponseEntity.status(HttpStatus.OK).body(ret);
	}
}
