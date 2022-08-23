package pe.com.restapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.restapi.entity.Person;
import pe.com.restapi.jparepository.IPersonRepository;
import pe.com.restapi.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private IPersonRepository personRepo;
	
	@Override
	public Person add(Person obj) {
		// TODO Auto-generated method stub
		return personRepo.save(obj);
	}

	@Override
	public Person update(Person obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
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
