package com.dwatkins.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwatkins.relationships.models.License;
import com.dwatkins.relationships.models.Person;
import com.dwatkins.relationships.services.DriverService;

@Controller
public class DriversController {
	private final DriverService driverService;
	
	public DriversController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Object[]> allDrivers = driverService.allDrivers();
		model.addAttribute("drivers", allDrivers);
		return "drivers/home.jsp";
	}
	
	@RequestMapping("/people")
	public String newPerson() {
		return "drivers/newPerson.jsp";
	}
	
	@RequestMapping(value="/people", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "drivers/newPerson.jsp";
		}
		else {
			driverService.createPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/licenses")
	public String newLicense(Model model) {
		List<Person> eligiblePeople = driverService.peopleWithoutLicense();
		model.addAttribute("eligibles", eligiblePeople);
		return "drivers/newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "drivers/newLicense.jsp";
		}
		else {
			driverService.createLicense(license);
			return "redirect:/";
		}
	}
}
