package net.boutallaka.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.boutallaka.entities.Client;
import net.boutallaka.repositories.ClientRepository;
@Service
public class ClientMetierImp implements ClientMetier{
    @Autowired 
	private ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
