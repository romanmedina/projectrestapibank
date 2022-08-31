package pe.com.restapi.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.restapi.entity.AccountSaving;

public interface IAccountSavingRepository extends ReactiveCrudRepository<AccountSaving, Integer>{

}
