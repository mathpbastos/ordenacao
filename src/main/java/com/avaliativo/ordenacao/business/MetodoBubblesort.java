package com.avaliativo.ordenacao.business;

import java.util.List;

public class MetodoBubblesort extends MetodoOrdenacao {

    
    public MetodoBubblesort(String nome){
        super(nome);
    }
    
    @Override
    public void ordenarCrescente(List<Double> lista) {
        for(int i = lista.size() -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(lista.get(j) > lista.get(j+1)){
                    double aux = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, aux);
                }
            }
        }
    }

    @Override
    public void ordenarDecrescente(List<Double> lista) {
        for(int i = lista.size() -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(lista.get(j) < lista.get(j+1)){
                    double aux = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, aux);
                }
            }
        }
    }
    
    
    
}
