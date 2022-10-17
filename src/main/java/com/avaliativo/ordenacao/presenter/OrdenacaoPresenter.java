package com.avaliativo.ordenacao.presenter;

import com.avaliativo.ordenacao.business.MetodoOrdenacao;
import com.avaliativo.ordenacao.collection.MetodoOrdenacaoCollection;
import com.avaliativo.ordenacao.view.OrdenacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OrdenacaoPresenter {
    private OrdenacaoView view;
    private Path path;
    private DefaultListModel listModelDesordenado;
    private DefaultListModel listModelOrdenado;
    private List<Double> listaDesordenada;
    private List<Double> listaOrdenada;
    private MetodoOrdenacaoCollection metodos;
    
    public OrdenacaoPresenter(MetodoOrdenacaoCollection metodos){
        view = new OrdenacaoView();
        this.metodos = metodos;
        initComboBox();
        carregarArquivo();
    }
    
    private void initComboBox(){
        view.getCmbMetodo().removeAllItems();
        for(MetodoOrdenacao metodo : metodos.getMetodos()){
            view.getCmbMetodo().addItem(metodo.getNome());
        }     
    }
    
    private void carregarArquivo(){
        view.getBtnCarregarArquivo().addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        getArquivo();                 
                    }
                }
        );    
    }
    
    private void getArquivo(){
        JFileChooser fileChooser = view.getFileChooser();
        int opt = fileChooser.showOpenDialog(view);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(opt == JFileChooser.CANCEL_OPTION)
            JOptionPane.showMessageDialog(view, "Operação abortada.",
                    "CANCELADO", JOptionPane.INFORMATION_MESSAGE);
        this.path = fileChooser.getSelectedFile().toPath();
    }
    
    
    
}
