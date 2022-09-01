package pe.com.restapi.service;

import pe.com.restapi.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

	Flux<Person> getAll();
	Mono<Person> create(Person person);
	Flux<Person> findById(Integer id);
	Flux<Person> findByDNI(String dni);
	Mono<Person> update(Person person);
	Mono<Void> delete(Person person);
}
