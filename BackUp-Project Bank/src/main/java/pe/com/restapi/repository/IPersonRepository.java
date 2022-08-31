package pe.com.restapi.repository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.restapi.entity.Person;
import reactor.core.publisher.Flux;


@Repository
public interface IPersonRepository extends ReactiveCrudRepository<Person, Integer>{

	@Query("{'phone': ?0}")
	Flux<Person> findByPhone(String phone);
}
