package com.avaliativo.ordenacao.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class LeitorArquivoTxtHandler extends LeitorHandler{
    
    @Override
    public boolean validarArquivo(Path path) {
       if(path == null)
            throw new RuntimeException("Por favor, "
                    + "especifique o caminho do arquivo a ser aberto");
       File arquivo = new File(path.toString());
       if(!arquivo.canRead()){
           throw new RuntimeException("Não foi possível ler o arquivo"
                  + "no caminho especificado.");
       }
       if(arquivo.getName().endsWith(".txt")){
           lerArquivo(path);
           return true;
       }
       return getProximo(path);
    }

    @Override
    public List<Double> lerArquivo(Path path) {
       List<Double> lista = new ArrayList();
       try{
           BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
           String lido;
           while((lido = br.readLine()) != null){
               if(lido.matches("^[0-9]+.[0-9]+")){
                    lista.add(Double.valueOf(lido));
               }
           }
       }
       catch(FileNotFoundException e){
           JOptionPane.showMessageDialog(null,
                   "Não foi possível localizar o arquivo com o path informado.",
                   "ERRO",
                   JOptionPane.ERROR_MESSAGE);
       }
       catch(IOException e){
           JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo especificado",
                   "ERRO",
                   JOptionPane.ERROR_MESSAGE);
       }
       return lista;
    }
}
