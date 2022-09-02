package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountSavingRepository;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IAccountSavingClientService;
import pe.com.restapibank.service.IAccountSavingService;
import pe.com.restapibank.utils.Constant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class AccountSavingImpl implements IAccountSavingService{

	@Autowired
	private IAccountSavingRepository iIAccountSavingRepository;
	
	@Autowired
	private IClientRepository clientRepos;
	
	@Autowired IAccountSavingClientService accountSavingService;

	@Override
	public Flux<AccountSaving> getAll() {
		return iIAccountSavingRepository.findAll();
	}

	@Override
	public Mono<AccountSaving> save(AccountSaving account_saving) {
		return iIAccountSavingRepository.save(account_saving);
	}
	
	@Override
	public Mono<Void> delete(AccountSaving account_saving) {
		return iIAccountSavingRepository.delete(account_saving);
	}

	@Override
	public Flux<AccountSaving> findById(Integer id) {
		return iIAccountSavingRepository.findAll().filter(x -> x.getIdSaving().equals(id));
	}

	@Override
	public Mono<AccountSaving> saveAccSavingByClient(AccountSaving accountSaving) {
		log.info("*****Guardando: saveAccSavingByClientPersonnel*****");
		Flux<AccountSaving> savingss = accountSavingService.getAccountSavingByClient(accountSaving.getIdClient());
		Mono<Client> clientss = clientRepos.findById(accountSaving.getIdClient());

		if(clientss.block().getTypeClient().equals(Constant.Personnel) && 
				!clientss.block().getTypeClient().equals(Constant.Bussiness)) {
			if (!(savingss.count().block().longValue()>0)){
				log.info("**Se creó correctamente la Cuenta de Ahorro/Corriente para el cliente personal**");
				return iIAccountSavingRepository.save(accountSaving);
			}else {
				log.info("**CREACIÓN FALLIDA: La cuenta ya existe ó El ciente no es de tipo personal**");
				return null;
			}
		}else {
				log.info("**CREACIÓN FALLIDA: No se puede crear cuenta de ahorros ,el ciente es de tipo empresarial**");
				return null;
		}	
	}

}
