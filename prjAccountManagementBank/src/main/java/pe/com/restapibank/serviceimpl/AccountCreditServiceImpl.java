package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.repository.IAccountCreditRepository;
import pe.com.restapibank.service.IAccountCreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountCreditServiceImpl implements IAccountCreditService{

	@Autowired
	IAccountCreditRepository creditRepo;
	
	//Obtiene todas las cuentas de credito
	@Override
	public Flux<AccountCredit> getAccountCredit() {
		return creditRepo.findAll();
	}

	//Buscar las cuentas de credito por id del cliente
	@Override
	public Flux<AccountCredit> findAccCreditByClient(Integer idClient) {
		return creditRepo.findAll().filter(x -> x.getIdClient().equals(idClient));
	}

	//Guardar un registro de cuenta de credito
	@Override
	public Mono<AccountCredit> create(AccountCredit Credit) {
		return creditRepo.save(Credit);
	}

	//Actualiza el deposito
	//Actualiza el saldo y la cantidad de meses de la linea de credito
	@Override
	public Mono<AccountCredit> depositCredit(AccountCredit Credit) {
		// TODO Auto-generated method stub
		return creditRepo.save(Credit);
	}

}
