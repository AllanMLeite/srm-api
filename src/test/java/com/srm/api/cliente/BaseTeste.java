package com.srm.api.cliente;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srm.api.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class BaseTeste {

	@Autowired
	private ClienteRepository clienteRepository;

	protected void limparBase() {
		clienteRepository.deleteAll();
	}

	protected abstract void finalizar();
}
