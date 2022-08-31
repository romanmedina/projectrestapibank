package pe.com.restapi.service;

import pe.com.restapi.entity.AccountSaving;
import pe.com.restapi.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingClientService {
	
	Flux<Client> getByIdClient(Integer idClient);
	Mono<AccountSaving> save(AccountSaving account_saving);
	Flux<AccountSaving> getByIdClientAccount(Integer idClient);

}
