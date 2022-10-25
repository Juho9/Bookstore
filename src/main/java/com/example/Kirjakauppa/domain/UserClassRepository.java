package com.example.Kirjakauppa.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserClassRepository extends CrudRepository<UserClass, Long> {
	
	UserClass findByUsername(String username);

}
