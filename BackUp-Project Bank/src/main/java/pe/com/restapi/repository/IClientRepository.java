package pe.com.restapi.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.com.restapi.entity.Client;

public interface IClientRepository extends ReactiveCrudRepository<Client, Integer>{

}
