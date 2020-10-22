package com.dwatkins.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dwatkins.relationships.models.License;
import com.dwatkins.relationships.models.Person;
import com.dwatkins.relationships.repositories.LicenseRepository;
import com.dwatkins.relationships.repositories.PersonRepository;

@Service
public class DriverService {
	private final PersonRepository personRepo;
	private final LicenseRepository licenseRepo;
	
	public DriverService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
	public List<Object[]> allDrivers() {
		return personRepo.joinPeopleAndLicenses();
	}
	
	public List<Person> peopleWithoutLicense() {
		return personRepo.peopleWithoutLicense();
	}
}
