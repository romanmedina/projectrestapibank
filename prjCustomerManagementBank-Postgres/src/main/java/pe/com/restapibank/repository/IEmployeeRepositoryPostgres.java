package pe.com.restapibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapibank.entity.Employee;

@Repository
public interface IEmployeeRepositoryPostgres extends JpaRepository<Employee, Integer>{

}
