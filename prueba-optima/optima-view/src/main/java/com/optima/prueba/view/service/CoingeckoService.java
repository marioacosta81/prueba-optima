package com.optima.prueba.view.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.optima.prueba.commons.domain.ClientData;
import com.optima.prueba.commons.domain.Root;
import com.optima.prueba.commons.exceptions.OptimaExceptions;
import com.optima.prueba.view.configuration.PropertiesClient;

@Service
public class CoingeckoService implements ICoingeckoService{
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	PropertiesClient propertiesClient;
	
	
	
	public List<Root> getList() throws OptimaExceptions {

		try {
			ResponseEntity<Root[]> response = restTemplate.getForEntity(propertiesClient.getEndpoint(), Root[].class);

			if (response == null || response.getBody() == null) {
				throw new OptimaExceptions("Error. respuesta vacia del servicio");
			}
			Root[] array = response.getBody();
			return Arrays.asList(array);
		} catch (RestClientException e) {
			throw new OptimaExceptions("Error. consultando el servicio de la lista. "+ e.getMessage());
		}

	}
	
	public Page<Root> getListPaginated(Pageable pageable) throws OptimaExceptions {

		List<Root> listRoots = getList();

		List<Root> sublistRoots;

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		if (listRoots.size() < startItem) {
			sublistRoots = Collections.emptyList();
		} else {

			int toIndex = Math.min(startItem + pageSize, listRoots.size());

			sublistRoots = listRoots.subList(startItem, toIndex);
		}

		Page<Root> rootPage = new PageImpl<Root>(sublistRoots, PageRequest.of(currentPage, pageSize), listRoots.size());

		return rootPage;

	}

	@Override
	public ClientData save(ClientData clientData) throws OptimaExceptions {
		try {
			
			clientData.setDateCurrent(Calendar.getInstance().getTime());
			
			ResponseEntity<ClientData> response = restTemplate.postForEntity(propertiesClient.getEndpointPersistence(),clientData ,ClientData.class);

			if (response == null || response.getBody() == null) {
				throw new OptimaExceptions("Error. guardando informacion");
			}
			
			return response.getBody();
		} catch (RestClientException e) {
			throw new OptimaExceptions("Error. consultando el servicio de la lista. "+ e.getMessage());
		}
	}
	
	
	

}
