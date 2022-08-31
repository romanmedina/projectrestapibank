package pe.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapi.entity.postgres.Employee;

@Repository
public interface IEmployeeRepositoryPostgres extends JpaRepository<Employee, Integer>{

}
