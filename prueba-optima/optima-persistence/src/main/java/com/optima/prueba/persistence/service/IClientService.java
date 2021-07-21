package com.optima.prueba.persistence.service;

import com.optima.prueba.commons.exceptions.OptimaExceptions;
import com.optima.prueba.persistence.model.Client;

public interface IClientService {
	
	
	
	Client save(Client client)throws OptimaExceptions;
	
	

}
