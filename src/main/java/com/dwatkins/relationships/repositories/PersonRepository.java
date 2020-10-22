package com.dwatkins.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dwatkins.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
	@Query("SELECT p, l FROM Person p JOIN p.license l")
	List<Object[]> joinPeopleAndLicenses();
	
	@Query("SELECT p FROM Person p WHERE p.license IS NULL")
	List<Person> peopleWithoutLicense();
}
