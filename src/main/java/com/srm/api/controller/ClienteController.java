package com.srm.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srm.api.model.Cliente;
import com.srm.api.service.ClienteService;

@RestController
public class ClienteController {

    @Resource
    private ClienteService clienteService;

    @RequestMapping("/cliente")
    public Cliente incluir(@RequestParam(value="nome", defaultValue = "") String nome) {
        return clienteService.salvar(null);
    }
}