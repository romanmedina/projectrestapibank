package pe.com.restapibank.service;

import pe.com.restapibank.entity.Client;
import pe.com.restapibank.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {
	
	Flux<Client> getAll();
	Mono<Client> create(Client client);
	Flux<Client> findById(Integer id);
	Mono<Client> update(Client client);
	Mono<Client> save(Client client);
	//Resilence4j
	Mono<Client> getClientById(Integer id);
	Mono<Person> getPersonByIdEmployee(Integer id);
}
