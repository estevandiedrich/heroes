package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withAddresses", types = Hero.class)
public interface WithAddresses {
	@Value("#{target.id}")
	String getId();
	@Value("#{target.name}")
	String getName();
	@Value("#{target.power}")
	String getPower();
	List<Address> getAddresses();
}
