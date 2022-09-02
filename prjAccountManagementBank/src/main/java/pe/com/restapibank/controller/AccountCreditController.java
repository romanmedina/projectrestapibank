package pe.com.restapibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.service.IAccountCreditService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account_credit")
@Slf4j
public class AccountCreditController {

	@Autowired
	private IAccountCreditService accountCreditService;
	
    @DeleteMapping("/delete")
    public ResponseEntity<Mono<Void>> delete(@RequestBody AccountCredit account_saving ){
    	Mono<Void> p = accountCreditService.delete(account_saving);
        return new ResponseEntity<Mono<Void>>(p, HttpStatus.NO_CONTENT);
    }
    
	@PostMapping
	public Mono<AccountCredit> create(@RequestBody AccountCredit account_saving){
		return accountCreditService.create(account_saving);
	}
	    
	@PostMapping("/creditbyclient")
	public Mono<AccountCredit> saveAccCreditByClient(@RequestBody AccountCredit accountCredit){
		log.info("*****Inicio: saveAccSavingByClientPersonnel*****");
		return accountCreditService.saveAccountCreditByClient(accountCredit);
	}	
    
}
