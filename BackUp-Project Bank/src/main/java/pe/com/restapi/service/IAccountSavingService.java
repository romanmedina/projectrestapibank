package pe.com.restapi.service;

import pe.com.restapi.entity.AccountSaving;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingService {
	
	Flux<AccountSaving> getAll();
	Mono<AccountSaving> save(AccountSaving account_saving);

}
