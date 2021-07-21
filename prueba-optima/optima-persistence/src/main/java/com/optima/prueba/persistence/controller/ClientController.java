package com.optima.prueba.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.optima.prueba.commons.exceptions.OptimaExceptions;
import com.optima.prueba.persistence.model.Client;
import com.optima.prueba.persistence.service.IClientService;

@Controller
public class ClientController {
	
	@Autowired
	IClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<?> persienteceSave(@RequestBody Client client){
		try {
			clientService.save(client);
			return ResponseEntity.ok().body(clientService.save(client));
		}catch(OptimaExceptions e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
