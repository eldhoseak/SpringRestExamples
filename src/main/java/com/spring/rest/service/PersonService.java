package com.spring.rest.service;

import com.spring.rest.exception.ResourceNotFoundException;
import com.spring.rest.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

	private Map<String, Person> personsDB = new HashMap<String, Person>();

	// save person details.
	public void addPerson(Person person){
		// for simplicity we are assigning the first name as key.
		this.personsDB.put(person.getFirstName(), person);
	}

	public void updatePerson(Person person){
		// for simplicity we are assigning the first name as key.
		this.personsDB.put(person.getFirstName(), person);
	}

	// return all persons
	public List<Person> getAllPersons() throws ResourceNotFoundException {


		List<Person> personList = new ArrayList<Person>();
		for (Person person : personsDB.values())
		{
			personList.add(person);
		}
		if(personList.isEmpty()){
			throw new ResourceNotFoundException("Person details is not found in databse.");
		}

		return personList;
	}

	public Person findByName (String name) throws ResourceNotFoundException {

		Person person = personsDB.get(name);
		if(person == null){
			throw new ResourceNotFoundException("Person "+name+" is not found in databse.");
		}

		return person;
	}

	public Person deletePerson (String name){
		return personsDB.remove(name);
	}
}
