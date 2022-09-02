package pe.com.restapibank.service;

import pe.com.restapibank.entity.AccountCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountCreditService {
	
	Flux<AccountCredit> getAccountCredit();
	Flux<AccountCredit> findAccCreditByClient(Integer idClient);
	Mono<AccountCredit> create(AccountCredit fixed);
	Mono<AccountCredit> depositCredit(AccountCredit fixed);
	
}