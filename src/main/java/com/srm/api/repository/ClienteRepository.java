package com.srm.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.srm.api.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}