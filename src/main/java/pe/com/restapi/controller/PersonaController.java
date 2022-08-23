package pe.com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.restapi.mongo.Persona;
import pe.com.restapi.service.IPersonaService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@PostMapping
	public Mono<Persona> registrar(@RequestBody Persona persona){
		return personaService.save(persona);
	}
}
