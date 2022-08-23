package pe.com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.restapi.entity.Person;
import pe.com.restapi.service.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll(){
		List<Person> getAll = personService.getAll();
		return new ResponseEntity<List<Person>>(getAll,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> add(@RequestBody Person person){
		Person p = personService.add(person);
		return new ResponseEntity<Person>(p, HttpStatus.CREATED);
	}
	
	
}
