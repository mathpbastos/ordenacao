package com.avaliativo.ordenacao.business;

import java.util.List;

public abstract class MetodoOrdenacao {
    private String nome;
    
    public MetodoOrdenacao(String nome){
        this.nome = nome;
    }
    
    public abstract void ordenarCrescente(List<Double> lista);
    
    public abstract void ordenarDecrescente(List<Double> lista);

    public String getNome() {
        return nome;
    }
}