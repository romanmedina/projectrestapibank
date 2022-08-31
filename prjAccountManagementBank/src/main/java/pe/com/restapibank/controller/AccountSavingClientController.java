package pe.com.restapibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.service.IAccountSavingClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account_saving_client")
public class AccountSavingClientController {

	@Autowired
	private IAccountSavingClientService accountSavingClientService;
	
	@GetMapping("/accountClient/{id}")
	public Flux<AccountSaving> getAccountByClient(@PathVariable("id") Integer id){
		return accountSavingClientService.getByIdClientAccount(id);
	}
	
	@GetMapping("/client/{id}")
	public Flux<Client> getByClient(@PathVariable("id") Integer id){
		return accountSavingClientService.getByIdClient(id);
	}

	
	@PostMapping
	public Mono<AccountSaving> registrar(@RequestBody AccountSaving account_saving){
		return accountSavingClientService.save(account_saving);
	}
	
	
}
