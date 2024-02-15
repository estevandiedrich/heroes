package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequestMapping("/heroes2")
public class HeroController {
	
	@Autowired
	private HeroRepository2 repo;
	
	@GetMapping("/getherobyid")
	public ResponseEntity<Hero> getHeroById(@RequestParam(name = "id") String id){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(Long.valueOf(id)).get());
	}
}
