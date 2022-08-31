package pe.com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.restapi.entity.postgres.Person;
import pe.com.restapi.service.IPersonServicePostgres;

@RestController
@RequestMapping("/persona")
public class PersonControllerPostgres {

	@Autowired
	private IPersonServicePostgres personaService;
	
    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
    	Person h = personaService.create(person);
        return new ResponseEntity<Person>(h, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Integer id){
    	Person persona = personaService.findById(id);
        return new ResponseEntity<Person>(persona, HttpStatus.OK);
    }
}
