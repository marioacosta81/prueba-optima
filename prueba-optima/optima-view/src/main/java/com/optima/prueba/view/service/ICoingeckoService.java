package com.optima.prueba.view.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.optima.prueba.commons.domain.ClientData;
import com.optima.prueba.commons.domain.Root;
import com.optima.prueba.commons.exceptions.OptimaExceptions;

public interface ICoingeckoService {
	
	List<Root> getList() throws OptimaExceptions;
	
	Page<Root> getListPaginated(Pageable pageable) throws OptimaExceptions;
	
	ClientData save(ClientData clientData) throws OptimaExceptions;
	
	
	
}
