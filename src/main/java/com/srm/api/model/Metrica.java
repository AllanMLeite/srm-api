package com.srm.api.model;

public class Metrica {

    private long id;
    private String nome;

    public Metrica(String nome){
        setNome(nome);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}