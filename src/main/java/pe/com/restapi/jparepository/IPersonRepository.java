package pe.com.restapi.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapi.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer>{

}
