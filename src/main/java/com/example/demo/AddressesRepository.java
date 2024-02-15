package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(itemResourceRel = "address",collectionResourceRel = "addresses",path = "addresses", exported = true)
public interface AddressesRepository extends CrudRepository<Address, Long>{

}
