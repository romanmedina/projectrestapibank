package pe.com.restapi.service;

import pe.com.restapi.mongo.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaService {
	
	Flux<Persona> getAll();
	Mono<Persona> save(Persona persona);

}
