package com.avaliativo.ordenacao.business;

import java.util.List;

public class MetodoSelectionsort extends MetodoOrdenacao{
    
    public MetodoSelectionsort(String nome){
        super(nome);
    }

    @Override
    public void ordenarCrescente(List<Double> lista) {
        for(int i = 0; i < lista.size() - 1; i++){
            int menor = i;
            
            for(int j = i+1; j < lista.size(); j++){
                if(lista.get(j) < lista.get(menor)){
                    menor = j;
                }
            }
            double aux = lista.get(i);
            lista.set(i, lista.get(menor));
            lista.set(menor, aux);
        }
    }

    @Override
    public void ordenarDecrescente(List<Double> lista) {
        for(int i = 0; i < lista.size() - 1; i++){
            int menor = i;
            
            for(int j = i+1; j < lista.size(); j++){
                if(lista.get(j) > lista.get(menor)){
                    menor = j;
                }
            }
            double aux = lista.get(i);
            lista.set(i, lista.get(menor));
            lista.set(menor, aux);
        }
    }
    
}
