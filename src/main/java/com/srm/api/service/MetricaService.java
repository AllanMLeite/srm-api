package com.srm.api.service;

import javax.annotation.Resource;

import com.srm.api.model.Metrica;
import com.srm.api.repository.MetricaRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;

@Service
public class MetricaService {

    @Resource
    private MetricaRepository metricaRepository;

    public Metrica salvarMetrica(String nome){
        validarInclusao(nome);
        return metricaRepository.incluir(new Metrica(nome));
    }

    private void validarInclusao(String nome) {
        validaObrigatoriedadeNome(nome);
    }

    private void validaObrigatoriedadeNome(String nome){
        if(StringUtils.isEmpty(nome))
            throw new RestClientException("Informe o nome.");
    }

    public void setMetricaRepository(MetricaRepository metricaRepository){
        this.metricaRepository = metricaRepository;
    }
}