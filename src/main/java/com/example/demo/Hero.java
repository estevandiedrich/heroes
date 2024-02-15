package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.AccessType;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "id",
		scope = Long.class)
@JsonDeserialize(using = HeroDeserializer.class)
public class Hero extends RepresentationModel<Hero> {
	public Hero() {}
	public Hero(String name, String power) {
		this.name = name;
		this.power = power;
	}
	public Hero(Long id, String name, String power) {
		this.id = id;
		this.name = name;
		this.power = power;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String power;
	@OneToMany(mappedBy = "hero",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Address> addresses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@AccessType(AccessType.Type.PROPERTY)
	public void setLinks(List<Link> links) {
	    super.removeLinks();
	    super.add(links);
	}
}
