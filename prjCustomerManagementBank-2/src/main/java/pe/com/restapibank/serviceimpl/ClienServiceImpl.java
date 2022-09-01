package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IClientService;
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
		log.info("------------ENTRÓ A SAVE----------");
		String typeClient = client.getTypeClient();
		if (Constant.Personnel.equals(typeClient.toString()) || Constant.Bussiness.equals(typeClient.toString())) {
			log.info("El cliente solo puede tener una cuenta personal o una cuenta empresarial");
			return null;
		}else {		
			log.info("GUARDADO");
			return clientRepo.save(client);
		}
		
	}
	
}
