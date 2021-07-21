package com.optima.prueba.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optima.prueba.commons.exceptions.OptimaExceptions;
import com.optima.prueba.persistence.model.Client;
import com.optima.prueba.persistence.repository.ClientRepository;

@Service
public class ClientService implements IClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client client) throws OptimaExceptions {
		
		if(null == client) {
			throw new OptimaExceptions("Error. La informacion de guardado esta vacia");
		}
		
		return clientRepository.save(client);
	}
	
	
	
}
