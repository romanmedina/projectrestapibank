package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.AccountFixed;
import pe.com.restapibank.repository.IAccountFixedRepository;
import pe.com.restapibank.service.IAccountFixedService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountFixedServiceImpl implements IAccountFixedService{

	@Autowired
	IAccountFixedRepository fixedRepo;
	
	//Obtiene todas las cuentas de plazo fijo
	@Override
	public Flux<AccountFixed> getAccountFixed() {
		return fixedRepo.findAll();
	}

	//Buscar las cuentas de plazo fijo por id del cliente
	@Override
	public Flux<AccountFixed> findAccFixedByClient(Integer idClient) {
		return fixedRepo.findAll().filter(x -> x.getIdClient().equals(idClient));
	}

	//Guardar un registro de cuenta a plazo fijo
	@Override
	public Mono<AccountFixed> create(AccountFixed fixed) {
		return fixedRepo.save(fixed);
	}

	//Actualiza el deposito
	//Actualiza el saldo y la cantidad de meses de plazo fijo
	@Override
	public Mono<AccountFixed> depositFixed(AccountFixed fixed) {
		// TODO Auto-generated method stub
		return fixedRepo.save(fixed);
	}

	@Override
	public Mono<AccountFixed> retreatFixed(AccountFixed fixed) {
		// TODO Auto-generated method stub
		return fixedRepo.save(fixed);
	}

}
