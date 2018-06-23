package com.srm.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.srm.api.model.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes;
    private final AtomicLong idSequence = new AtomicLong();

    public ClienteRepository(){
        clientes = new ArrayList<>();
    }

    public Cliente incluir(Cliente cliente){
        cliente.setId(idSequence.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

	public ArrayList<Cliente> listar() {
		return (ArrayList<Cliente>) clientes;
	}    
}