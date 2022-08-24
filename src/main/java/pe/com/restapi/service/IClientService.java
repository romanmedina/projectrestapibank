package pe.com.restapi.service;

import pe.com.restapi.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {
	
	Flux<Client> getAll();
	Mono<Client> create(Client client);
	Flux<Client> findById(Integer id);
	Mono<Client> update(Client client);

}
