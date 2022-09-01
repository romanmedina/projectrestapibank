package pe.com.restapibank.service;

import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingClientService {
	
	Flux<Client> getByIdClient(Integer idClient);
	Mono<AccountSaving> save(AccountSaving account_saving);
	Flux<AccountSaving> getByIdClientAccount(Integer idClient);

}
