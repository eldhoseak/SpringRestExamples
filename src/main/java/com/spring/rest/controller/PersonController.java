package com.spring.rest.controller;

import com.spring.rest.exception.ResourceNotFoundException;
import com.spring.rest.model.Person;
import com.spring.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	@GetMapping("/personByName/{name}")
	public ResponseEntity getPersonByName(@PathVariable String name) throws ResourceNotFoundException {
		return  new ResponseEntity(personService.findByName(name), HttpStatus.OK);
	}

	@GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getAll() {

		// demonstrates the ResponseStatusException
		try {
			return personService.getAllPersons();
		}
		catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person details Not Found", exc);
		}
	}

	@PutMapping(value = "/person")
	public HttpStatus insertPerson(@RequestBody Person person) {
		 personService.addPerson(person);
		 return HttpStatus.CREATED;
	}

	@PostMapping(value = "/person")
	public HttpStatus updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
		return HttpStatus.OK;
	}

	@DeleteMapping("/deletePerson/{name}")
	public HttpStatus deletePerson(@PathVariable String name) {
		 personService.deletePerson(name);
		return HttpStatus.OK;
	}
}

