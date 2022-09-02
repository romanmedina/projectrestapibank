package pe.com.restapibank.serviceimpl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Movement;
import pe.com.restapibank.repository.IMovementRepository;
import pe.com.restapibank.service.IAccountSavingService;
import pe.com.restapibank.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MovementServiceImpl implements IMovementService{

	@Autowired 
	IMovementRepository movementRepo;
	
	@Autowired
	IAccountSavingService accountSavingService;

	@Override
	public Flux<Movement> getAll() {
		return movementRepo.findAll();
	}

	@Override
	public Mono<Movement> create(Movement movement) {
		
		log.info("*****Inicio: Crear Movimiento Ahorros*****");
		log.info("*************************************************************");
		Mono<Movement> saving = null;
		// No busca en la tabla de comision "Libre de comission"
		int month = LocalDate.now().getMonthValue();
		Integer intNumberMovMax = 0;
		Flux<AccountSaving> objFluxAccountSaving = accountSavingService.findById(movement.getIdSaving());
		List<AccountSaving> listAccountSaving = objFluxAccountSaving.collectList().block();
		for (Iterator<AccountSaving> iterator = listAccountSaving.iterator(); iterator.hasNext();) {
			AccountSaving accountSaving = (AccountSaving) iterator.next();
			intNumberMovMax = accountSaving.getNumberMovMonth();
		}
		Flux<Movement> objFluxMovement = this.findByIdSavingForMonth(movement.getIdSaving(),month);
		if (objFluxMovement.count().block().longValue()+1>intNumberMovMax) {
			log.info("No esta permitido realizar mas movimientos en su cuenta de ahorros");
		}else{
			saving = movementRepo.save(movement);
		}
		return saving;
	}

	@Override
	public Flux<Movement> findById(Integer id) {
		return movementRepo.findAll().filter(x -> x.getIdMovementFixed().equals(id));
	}

	@Override
	public Mono<Movement> update(Movement movement) {
		return movementRepo.save(movement);
	}

	@Override
	public Mono<Void> delete(Movement movement) {
		return movementRepo.delete(movement);
	}
	
	@Override
	public Flux<Movement> findByIdSaving(Integer id) {
		return movementRepo.findAll().filter(x -> x.getIdSaving().equals(id));
	}

	@Override
	public Flux<Movement> findByIdFixed(Integer id) {
		return movementRepo.findAll().filter(x -> x.getIdFixed().equals(id));
	}
	
	@Override
	public Flux<Movement> findByIdCredit(Integer id) {
		return movementRepo.findAll().filter(x -> x.getIdCredit().equals(id));
	}
	
	@Override
	public Flux<Movement> findByIdSavingForMonth(Integer id, Integer month) {
		return movementRepo.findAll().filter(x -> x.getIdSaving().equals(id) && x.getDateMovement().getMonthValue()==month);
	}	

}
