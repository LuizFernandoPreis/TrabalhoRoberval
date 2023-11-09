
package Controller;

import Controller.utilities.Utilities;
import Model.bo.Bairro;
import View.TelaCadastroBairro;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import service.BairroService;

public class ControllerCadBairro implements ActionListener{
    
    List<Bairro> listaBairros = new ArrayList<Bairro>();
    TelaCadastroBairro telaCadastroBairro;
    ControllerBuscaBairro controller;
    view.TelaBuscaBairro a; 
    public ControllerCadBairro(TelaCadastroBairro telaCadastroBairro) {
        listaBairros = BairroService.carregar();
        this.a = new view.TelaBuscaBairro(null, true);
        this.controller = new ControllerBuscaBairro(a,this);
        this.telaCadastroBairro = telaCadastroBairro;
        this.telaCadastroBairro.getCancelar().addActionListener(this);
        this.telaCadastroBairro.getBuscar().addActionListener(this);
        this.telaCadastroBairro.getNovo().addActionListener(this);
        this.telaCadastroBairro.getGravar().addActionListener(this);
        this.telaCadastroBairro.getSair().addActionListener(this);
        this.telaCadastroBairro.getIdTexto().setText(Integer.toString(listaBairros.size() + 1));
        Controller.utilities.Utilities.ativa(true, this.telaCadastroBairro.getBody());
        this.telaCadastroBairro.getIdTexto().setEnabled(false);
        DAO.ClasseDados.getInstance();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroBairro.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroBairro.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroBairro.getBody());
        } else if(e.getSource() == this.telaCadastroBairro.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroBairro.getBody());
        }else if(e.getSource() == this.telaCadastroBairro.getGravar()){
            Component componente = Utilities.testaCampos(this.telaCadastroBairro.getBody());
            if( componente instanceof JFormattedTextField || componente instanceof JTextField){
                JOptionPane.showMessageDialog(null, "Há Campos Vazios!!!");
                componente.requestFocus();
            }else{
                if(Integer.parseInt(this.telaCadastroBairro.getIdTexto().getText()) > listaBairros.size()){
                
                Bairro bairro = new Bairro(listaBairros.size() + 1,this.telaCadastroBairro.getDescricaoTexto().getText());
                BairroService.adicionar(bairro);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroBairro.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroBairro.getBody());
                
                this.telaCadastroBairro.getIdTexto().setText( Integer.toString(listaBairros.size() + 1));
            }else if(listaBairros.contains(listaBairros.get(Integer.parseInt(this.telaCadastroBairro.getIdTexto().getText())-1))){
                
                listaBairros.get(Integer.parseInt(this.telaCadastroBairro.getIdTexto().getText()) - 1).setDescricao(this.telaCadastroBairro.getDescricaoTexto().getText());
                Bairro bairro = listaBairros.get(Integer.parseInt(this.telaCadastroBairro.getIdTexto().getText()) - 1);
                System.out.println(bairro);
                BairroService.atualizar(bairro);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroBairro.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroBairro.getBody());
                this.telaCadastroBairro.getIdTexto().setText( Integer.toString(listaBairros.size() + 1));
            
            }   
            }
            
            
        }else if(e.getSource() == this.telaCadastroBairro.getBuscar()){
            this.a.setVisible(true);
        }
    }
    
}
