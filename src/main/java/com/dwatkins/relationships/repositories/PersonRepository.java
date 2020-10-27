package com.dwatkins.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dwatkins.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
	@Query("SELECT p, l FROM Person p LEFT JOIN p.license l")
	List<Object[]> joinPeopleAndLicenses();
	
	@Query("SELECT p FROM Person p LEFT JOIN p.license l WHERE l.id IS NULL")
	List<Person> peopleWithoutLicense();
}
