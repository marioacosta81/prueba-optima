package com.optima.prueba.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.optima.prueba.persistence.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
