package pe.com.restapibank.service;

import pe.com.restapibank.entity.AccountSaving;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingService {
	
	Flux<AccountSaving> getAll();
	Mono<AccountSaving> save(AccountSaving account_saving);

}
