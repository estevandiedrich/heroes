package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(itemResourceRel = "hero",collectionResourceRel = "heroes",path = "heroes", exported = true)
public interface HeroRepository extends CrudRepository<Hero, Long>{
	List<Hero> findByName(@Param("name") String name);
}
