package pe.com.restapibank.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapibank.entity.Person;
import pe.com.restapibank.repository.IPersonRepositoryPostgres;
import pe.com.restapibank.service.IPersonServicePostgres;

@Service
public class PersonServiceImplPostgres implements IPersonServicePostgres{

	@Autowired
	IPersonRepositoryPostgres personRepo;
	
	@Override
	public Person create(Person obj) {
		return personRepo.save(obj);
	}

	@Override
	public Person update(Person obj) {
		return personRepo.save(obj);
	}

	@Override
	public List<Person> findAll() {
		return personRepo.findAll();
	}

	@Override
	public Person findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


}
