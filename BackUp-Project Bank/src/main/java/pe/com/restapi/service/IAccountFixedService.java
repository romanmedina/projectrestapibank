package pe.com.restapi.service;

import pe.com.restapi.entity.AccountFixed;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountFixedService {
	
	Flux<AccountFixed> getAccountFixed();
	Flux<AccountFixed> findAccFixedByClient(Integer idClient);
	Mono<AccountFixed> create(AccountFixed fixed);
	Mono<AccountFixed> depositFixed(AccountFixed fixed);
	
}
