package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapibank.entity.Movement;
import pe.com.restapibank.repository.IMovementRepository;
import pe.com.restapibank.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements IMovementService{

	@Autowired 
	IMovementRepository movementRepo;

	@Override
	public Flux<Movement> getAll() {
		return movementRepo.findAll();
	}

	@Override
	public Mono<Movement> create(Movement movement) {
		return movementRepo.save(movement);
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
