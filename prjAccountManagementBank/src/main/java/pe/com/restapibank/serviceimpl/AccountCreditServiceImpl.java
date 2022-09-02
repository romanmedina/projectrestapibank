package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountCreditRepository;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IAccountCreditService;
import pe.com.restapibank.service.IAccountSavingClientService;
import pe.com.restapibank.utils.Constant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AccountCreditServiceImpl implements IAccountCreditService{

	@Autowired
	IAccountCreditRepository creditRepo;

	@Autowired
	IAccountCreditRepository perso;
	
	
	@Autowired
	IClientRepository clientRepo;
	
	@Autowired
	IAccountSavingClientService accountCredClient;
	
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
		// Persona tipo Empresarial: se permite más de un crédito por empresa.
		log.info("*****Inicio: Crear Cuenta Cte*****");
		log.info("*************************************************************");
		
		return creditRepo.save(Credit);
	}

	//Actualiza el deposito
	//Actualiza el saldo y la cantidad de meses de la linea de credito
	@Override
	public Mono<AccountCredit> depositCredit(AccountCredit Credit) {
		// TODO Auto-generated method stub
		return creditRepo.save(Credit);
	}
	
	@Override
	public Mono<AccountCredit> retreatCredit(AccountCredit Credit) {
		// TODO Auto-generated method stub
		return creditRepo.save(Credit);
	}

	@Override
	public Mono<Void> delete(AccountCredit credit) {
		return creditRepo.delete(credit);
	}


	@Override
	public Mono<AccountCredit> saveAccountCreditByClient(AccountCredit accountCredit) {
		log.info("*****INICIO: Crear cuenta de credito por persona*****");
		Flux<AccountCredit> getAccountCreditByClient = accountCredClient.getAccountCreditByClient(accountCredit.getIdClient());
		Mono<Client> getClientById = clientRepo.findById(accountCredit.getIdClient());
		if(getClientById.block().getTypeClient().equals(Constant.Personnel) && 
				!getClientById.block().getTypeClient().equals(Constant.Bussiness)) {
			if(!(getAccountCreditByClient.count().block().longValue()>0)) {
				log.info("**EXITO: Se creó la cuenta de crédito Personal**");
				return creditRepo.save(accountCredit);
			}else {
				log.info("**ERROR: Ya existe una cuenta personal para el cliente**");
				return null;
			}
		}else {
			log.info("**ERROR: El cliente no es de tipo Personal**");
			return null;
		}

	}
}
