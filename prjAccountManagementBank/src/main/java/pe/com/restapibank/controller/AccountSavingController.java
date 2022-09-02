package pe.com.restapibank.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Movement;
import pe.com.restapibank.service.IAccountSavingService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account_saving")
@Slf4j
public class AccountSavingController {

	@Autowired
	private IAccountSavingService accountSavingService;
	
    @DeleteMapping("/delete")
    public ResponseEntity<Mono<Void>> delete(@RequestBody AccountSaving account_saving ){
    	Mono<Void> p = accountSavingService.delete(account_saving);
        return new ResponseEntity<Mono<Void>>(p, HttpStatus.NO_CONTENT);
    }
    
	@PostMapping
	public Mono<AccountSaving> save(@RequestBody AccountSaving account_saving){
		return accountSavingService.save(account_saving);
	}
	
	@PostMapping("/savingbyclient")
	public Mono<AccountSaving> saveAccSavingByClient(@RequestBody AccountSaving accountSaving){
		log.info("*****Inicio: saveAccSavingByClient*****");
		return accountSavingService.saveAccSavingByClient(accountSaving);
	    
	}
}
