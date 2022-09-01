package pe.com.restapibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.restapibank.entity.Holder;

@Repository
public interface IHolderRepositoryPostgres extends JpaRepository<Holder, Integer>{

}
