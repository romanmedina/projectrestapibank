package pe.com.restapibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapibank.entity.Person;

@Repository
public interface IPersonRepositoryPostgres extends JpaRepository<Person, Integer>{

}
