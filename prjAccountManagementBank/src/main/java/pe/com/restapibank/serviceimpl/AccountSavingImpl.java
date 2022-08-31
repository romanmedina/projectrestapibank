package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.repository.IAccountSavingRepository;
import pe.com.restapibank.service.IAccountSavingService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
