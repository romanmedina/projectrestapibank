package pe.com.restapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapi.jparepository.IPersonaRepository;
import pe.com.restapi.mongo.Persona;
import pe.com.restapi.service.IPersonaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	IPersonaRepository personaRep;
	
	@Override
	public Flux<Persona> getAll() {
		// TODO Auto-generated method stub
		return personaRep.findAll();
	}

	@Override
	public Mono<Persona> save(Persona persona) {
		// TODO Auto-generated method stub
		return personaRep.save(persona);
	}

}
