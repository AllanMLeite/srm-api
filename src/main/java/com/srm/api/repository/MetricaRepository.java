package com.srm.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.srm.api.model.Metrica;

import org.springframework.stereotype.Repository;

@Repository
public class MetricaRepository {

    private List<Metrica> metricas;
    private final AtomicLong idSequence = new AtomicLong();

    public MetricaRepository(){
        metricas = new ArrayList<>();
    }

    public Metrica incluir(Metrica metrica){
        metrica.setId(idSequence.incrementAndGet());
        metricas.add(metrica);
        return metrica;
    }    
}