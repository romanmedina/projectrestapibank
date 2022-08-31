package pe.com.restapibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.service.IAccountSavingClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account_saving")
public class AccountSavingController {

	@Autowired
	private IAccountSavingClientService accountSavingClientService;
	
	@GetMapping
	public Flux<AccountSaving> getById(){
		return accountSavingClientService.getByIdClientAccount(null);
	}
	
	@PostMapping
	public Mono<AccountSaving> save(@RequestBody AccountSaving account_saving){
		return accountSavingClientService.save(account_saving);
	}
	
	
}
