package pe.com.restapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapi.entity.AccountSaving;
import pe.com.restapi.repository.IAccountSavingRepository;
import pe.com.restapi.service.IAccountSavingService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountSavingImpl implements IAccountSavingService{

	@Autowired
	private IAccountSavingRepository iIAccountSavingRepository;
	

	@Override
	public Flux<AccountSaving> getAll() {
		return iIAccountSavingRepository.findAll();
	}

	@Override
	public Mono<AccountSaving> save(AccountSaving account_saving) {
		return iIAccountSavingRepository.save(account_saving);
	}


}
