/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Cidade;
import Service.CidadeService;
import View.TelaCadastroCidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import view.TelaBuscaCidade;

/**
 *
 * @author luizf
 */
public class ControllerCadCidade implements ActionListener{
       
        TelaCadastroCidade telaCadastroCidade;
        TelaBuscaCidade a = new TelaBuscaCidade(null, true);
        ControllerTelaBuscaCidade controllerTelaBuscaCidade; 
        List<Cidade> listaCidade = new ArrayList<Cidade>();
        
        public ControllerCadCidade(TelaCadastroCidade telaCadastroCidade) {
        listaCidade = CidadeService.carregar();
        this.controllerTelaBuscaCidade = new ControllerTelaBuscaCidade(a,this);
        this.telaCadastroCidade = telaCadastroCidade;
        this.telaCadastroCidade.getCancelar().addActionListener(this);
        this.telaCadastroCidade.getBuscar().addActionListener(this);
        this.telaCadastroCidade.getNovo().addActionListener(this);
        this.telaCadastroCidade.getGravar().addActionListener(this);
        this.telaCadastroCidade.getSair().addActionListener(this);
        this.telaCadastroCidade.getIdTexto().setText( Integer.toString(listaCidade.size() + 1));
        this.telaCadastroCidade.getIdTexto().setEnabled(false);
        listaCidade = CidadeService.carregar();
        Controller.utilities.Utilities.ativa(true, this.telaCadastroCidade.getBody());
    }
    
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroCidade.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroCidade.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCidade.getBody());
        } else if(e.getSource() == this.telaCadastroCidade.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroCidade.getBody());
        }else if(e.getSource() == this.telaCadastroCidade.getGravar()){
            
            if(Integer.parseInt(this.telaCadastroCidade.getIdTexto().getText()) > listaCidade.size()){
                Cidade cidade = new Cidade(listaCidade.size() + 1,this.telaCadastroCidade.getDescricaoTexto().getText(), this.telaCadastroCidade.getjTextField1().getText());
                CidadeService.adicionar(cidade);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCidade.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCidade.getBody());
                this.telaCadastroCidade.getIdTexto().setText( Integer.toString(DAO.ClasseDados.listaCidade.size() + 1));
            }else if(listaCidade.contains(listaCidade.get(Integer.parseInt(this.telaCadastroCidade.getIdTexto().getText())-1))){
                listaCidade.get(Integer.parseInt(this.telaCadastroCidade.getIdTexto().getText()) - 1).setDescricao(this.telaCadastroCidade.getDescricaoTexto().getText());
                listaCidade.get(Integer.parseInt(this.telaCadastroCidade.getIdTexto().getText()) - 1).setUf(this.telaCadastroCidade.getjTextField1().getText());
                Cidade cidade = listaCidade.get(Integer.parseInt(this.telaCadastroCidade.getIdTexto().getText()) - 1);
                CidadeService.atualizar(cidade);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCidade.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCidade.getBody());
                this.telaCadastroCidade.getIdTexto().setText( Integer.toString(DAO.ClasseDados.listaCidade.size() + 1));
            
            }else{
                
            }
        }else if (e.getSource() == this.telaCadastroCidade.getBuscar()){
            System.out.println("a");
            a.setVisible(true);
        }else if(e.getSource() == this.telaCadastroCidade.getSair()){
            this.telaCadastroCidade.dispose();
        }
    }
    
}

    

