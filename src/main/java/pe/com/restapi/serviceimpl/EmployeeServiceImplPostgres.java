package pe.com.restapi.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.restapi.entity.postgres.Employee;
import pe.com.restapi.repository.IEmployeeRepositoryPostgres;
import pe.com.restapi.service.IEmployeeServicePostgres;

@Service
public class EmployeeServiceImplPostgres implements IEmployeeServicePostgres{

	@Autowired
	IEmployeeRepositoryPostgres employeeRepo;
	
	@Override
	public Employee create(Employee obj) {
		
		return employeeRepo.save(obj);
	}

	@Override
	public Employee update(Employee obj) {
		return employeeRepo.save(obj);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		Optional<Employee> em = employeeRepo.findById(id);
		return em.isPresent() ? em.get() : new Employee();
	}

	@Override
	public boolean delete(Integer id) {
		employeeRepo.deleteById(id);
		return true;
	}

}
