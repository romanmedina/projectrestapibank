package pe.com.restapi.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.restapi.entity.AccountFixed;

public interface IAccountFixedRepository extends ReactiveCrudRepository<AccountFixed, Integer>{

}
