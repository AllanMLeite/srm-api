package com.srm.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import com.srm.api.model.Metrica;
import com.srm.api.service.MetricaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricaController {

    @Resource
    private MetricaService metricaService;

    @RequestMapping("/metrica")
    public Metrica incluirMetrica(@RequestParam(value="nome", defaultValue = "") String nome) {
        return metricaService.salvarMetrica(nome);
    }
}