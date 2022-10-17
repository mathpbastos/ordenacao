package com.avaliativo.ordenacao.leitor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class LeitorHandler {
    
    private LeitorHandler proximo;
    
    public final void encadear(LeitorHandler proximo){
        this.proximo = proximo;
    }

    public abstract boolean validarArquivo(Path path);
    
    public abstract List<Double> lerArquivo(Path path) throws IOException;
    
    protected boolean getProximo(Path path){
        if(this.proximo == null){
            return true;
        }
        return proximo.validarArquivo(path);
    }
    
}
