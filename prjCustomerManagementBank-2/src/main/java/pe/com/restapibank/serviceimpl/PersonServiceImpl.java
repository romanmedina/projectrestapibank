package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.restapibank.entity.Person;
import pe.com.restapibank.repository.IPersonRepository;
import pe.com.restapibank.service.IPersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired 
	IPersonRepository personRepo;
	
	@Override
	public Flux<Person> getAll() {
		return personRepo.findAll();
	}

	@Override
	public Mono<Person> create(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Flux<Person> findById(Integer id) {
		return personRepo.findAll().filter(x -> x.getIdPerson().equals(id));
	}
	
	@Override
	public Flux<Person> findByDNI(String dni) {
		return personRepo.findAll().filter(x -> x.getNumberDoc().equals(dni));
	}
	
	@Override
	public Mono<Person> update(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Mono<Void> delete(Person person) {
		return personRepo.delete(person);
	}

	@Override
	public Mono<Person> getPersonById(Integer id) {
		return Mono.just(new Person(10,"Romario","dni","33223344","2022-02-27T12:26:30.107","email@email.com","9384746",true,"PROMAN","123.23.2.22"));
	}
	
	
	

}
