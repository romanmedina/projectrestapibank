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
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.service.IAccountSavingService;
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
		
//		log.info("*****Inicio: Crear Movimiento Ahorros*****");
//		log.info("*************************************************************");
//		Mono<Movement> saving = null;
//		// No busca en la tabla de comision "Libre de comission"
//		// Flux<Comission> objFluxComission = comissionService.findByIdSaving(Movement.getIdSaving());
//		int month = LocalDate.now().getMonthValue();
//		Integer intNumberMovMax = 0;
//		Flux<AccountSaving> objFluxAccountSaving = accountSavingService.findById(Movement.getIdSaving());
//		List<AccountSaving> listAccountSaving = objFluxAccountSaving.collectList().block();
//		for (Iterator<AccountSaving> iterator = listAccountSaving.iterator(); iterator.hasNext();) {
//			AccountSaving accountSaving = (AccountSaving) iterator.next();
//			intNumberMovMax = accountSaving.getNumberMovMonth();
//		}
//		Flux<Movement> objFluxMovement = movementService.findByIdSavingForMonth(Movement.getIdSaving(),month);
//		if (objFluxMovement.count().block().longValue()+1>intNumberMovMax) {
//			log.info("No esta permitido realizar mas movimientos en su cuenta de ahorros");
//		}else{
//			saving = movementService.create(Movement);	
//		}
//		if (saving==null) {
//			return new ResponseEntity<Mono<Movement>>(saving, HttpStatus.PRECONDITION_FAILED);
//		}else{
//			return new ResponseEntity<Mono<Movement>>(saving, HttpStatus.CREATED);
//		}		
		
		return accountSavingService.save(account_saving);
	}
	
	@PostMapping("/savingpersonal")
	public Mono<AccountSaving> saveAccSavingByClient(@RequestBody AccountSaving accountSaving){
		log.info("*****Inicio: saveAccSavingByClient*****");
		return accountSavingService.saveAccSavingByClient(accountSaving);
	    
	}
	
	@PostMapping("/savingpersonalvip")
	public Mono<AccountSaving> saveAccSavingByClientVIP(@RequestBody AccountSaving accountSaving){
		log.info("*****Inicio: saveAccSavingByClientVIP*****");
		return accountSavingService.saveAccSavingByClientVIP(accountSaving);
	    
	}
	
	@PostMapping("/empresarialpyme")
	public Mono<AccountSaving> saveAccCurrentBussinessPyme(@RequestBody AccountSaving accountSaving){
		log.info("*****Inicio: saveAccCurrentBussinessPyme*****");
		return accountSavingService.saveAccCurrentBussinessPyme(accountSaving);
	    
	}
}
