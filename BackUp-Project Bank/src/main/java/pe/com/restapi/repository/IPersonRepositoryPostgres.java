package pe.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.restapi.entity.postgres.Person;

@Repository
public interface IPersonRepositoryPostgres extends JpaRepository<Person, Integer>{

}
