package com.avaliativo.ordenacao.collection;

import com.avaliativo.ordenacao.business.MetodoOrdenacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetodoOrdenacaoCollection {
    
    private ArrayList<MetodoOrdenacao> metodos;
    
    public MetodoOrdenacaoCollection(){
        this.metodos = new ArrayList();
    }
    
    public void add(MetodoOrdenacao metodo){
        if(metodo == null)
            throw new RuntimeException("O método passado não pode ser nulo.");
        if(metodos.contains(metodo))
            throw new RuntimeException("O método " + metodo.getNome() + " já está cadastrado.");
        
        metodos.add(metodo);
    }

    public List<MetodoOrdenacao> getMetodos() {
        return Collections.unmodifiableList(metodos);
    }
}
