package pe.com.restapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapi.entity.Client;
import pe.com.restapi.repository.IClientRepository;
import pe.com.restapi.service.IClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ClienServiceImpl implements IClientService{

	@Autowired
	IClientRepository clientRepo;
	
	@Override
	public Flux<Client> getAll() {
		return clientRepo.findAll();
	}

	@Override
	public Mono<Client> create(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public Flux<Client> findById(Integer id) {
		return clientRepo.findAll().filter(x -> x.getIdClient().equals(id));
	}

	@Override
	public Mono<Client> update(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public Mono<Client> save(Client client) {
		
		if (!(Constant.Personnel.equals(client.getTypeClient()) || Constant.Bussiness.equals(client.getTypeClient()))) {
			log.info("El campo idTypeClient debe ser de tipo: 0 Personal, 1 Empresarial");
			return null;
		}else {		
			return clientRepo.save(client);
		}
		
	}	
	
}
