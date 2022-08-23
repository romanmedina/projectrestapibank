package pe.com.restapi.jparepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapi.mongo.Persona;
import reactor.core.publisher.Flux;

@Repository
public interface IPersonaRepository extends ReactiveCrudRepository<Persona, Integer>{

	@Query("{'nombre': ?0}")
	Flux<Persona> buscaPersona(String dni);
}
