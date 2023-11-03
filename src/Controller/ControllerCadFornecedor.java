/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Endereco;
import Model.bo.Fornecedor;
import View.TelaCadastroEndereco;
import View.TelaCadastroFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.TelaBucaFornecedor;
import view.TelaBuscaEndereco;

public class ControllerCadFornecedor implements ActionListener, FocusListener{
    
     TelaCadastroFornecedor telaCadastroFornecedor;
     TelaBucaFornecedor telaBusca;
    
    private ControllerTelaBuscaFornecedor controller;
    public ControllerCadFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaBusca = new TelaBucaFornecedor(null, true);
        this.telaCadastroFornecedor = telaCadastroFornecedor;
        this.controller = new ControllerTelaBuscaFornecedor(telaBusca, this);
        this.telaCadastroFornecedor.getCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getNovo().addActionListener(this);
        this.telaCadastroFornecedor.getGravar().addActionListener(this);
        this.telaCadastroFornecedor.getSair().addActionListener(this);
        this.telaCadastroFornecedor.getNovoEnd().addActionListener(this);
        this.telaCadastroFornecedor.getEndBox().addFocusListener(this);
        Controller.utilities.Utilities.ativa(true, this.telaCadastroFornecedor.getBody());
        this.telaCadastroFornecedor.getIdTexto().setEnabled(false);
        this.telaCadastroFornecedor.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaFornecedor.size() + 1));
        for(int i = 0; i < DAO.ClasseDados.listaEndereco.size(); i++){
            if(DAO.ClasseDados.listaEndereco.get(i).getStatus() == "a"){
                this.telaCadastroFornecedor.getEndBox().addItem(Integer.toString(DAO.ClasseDados.listaEndereco.get(i).getId()));
            } 
        }
    }
    
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroFornecedor.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroFornecedor.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getBody());
        } else if(e.getSource() == this.telaCadastroFornecedor.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroFornecedor.getBody());
        }else if(e.getSource() == this.telaCadastroFornecedor.getGravar()){
            String on = "";
            if(this.telaCadastroFornecedor.getStatus().isSelected() == true){
                on = "a";
            }else if(this.telaCadastroFornecedor.getStatus().isSelected() == false){
                on = "a";
            }
            Endereco endereco = DAO.ClasseDados.listaEndereco.get(Integer.parseInt(this.telaCadastroFornecedor.getEndBox().getSelectedItem().toString() )-1);
            if(Integer.parseInt(this.telaCadastroFornecedor.getIdTexto().getText()) > DAO.ClasseDados.listaFornecedor.size()){
                Fornecedor fornecedor = new Fornecedor(this.telaCadastroFornecedor.getCnpjTexto().getText(), this.telaCadastroFornecedor.getInscricaoEstuadualTexto().getText(), 
                        this.telaCadastroFornecedor.getRazaoSocialTexto().getText(), Integer.parseInt(this.telaCadastroFornecedor.getIdTexto().getText()), this.telaCadastroFornecedor.getNomeTexto().getText(),
                        this.telaCadastroFornecedor.getFoneTexto().getText(), this.telaCadastroFornecedor.getFone2Texto().getText(), this.telaCadastroFornecedor.getEmailTexto().getText(), on, 
                        this.telaCadastroFornecedor.getComplementoTexto().getText(), endereco);
            DAO.ClasseDados.listaFornecedor.add(fornecedor);
            Controller.utilities.Utilities.ativa(true, this.telaCadastroFornecedor.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getBody());
            this.telaCadastroFornecedor.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaFornecedor.size() + 1));
            }else if(DAO.ClasseDados.listaFornecedor.contains(DAO.ClasseDados.listaFornecedor.get(Integer.parseInt(this.telaCadastroFornecedor.getIdTexto().getText())-1))){
                Fornecedor fn = DAO.ClasseDados.listaFornecedor.get(Integer.parseInt(this.telaCadastroFornecedor.getIdTexto().getText())-1);
                fn.setCnpj(this.telaCadastroFornecedor.getCnpjTexto().getText());
                fn.setInscricaoEstadual(this.telaCadastroFornecedor.getInscricaoEstuadualTexto().getText());
                fn.setRazaoSocial(this.telaCadastroFornecedor.getRazaoSocialTexto().getText());
                fn.setNome(this.telaCadastroFornecedor.getNomeTexto().getText());
                fn.setFone1(this.telaCadastroFornecedor.getFoneTexto().getText());
                fn.setFone2(this.telaCadastroFornecedor.getFone2Texto().getText());
                fn.setEmail(this.telaCadastroFornecedor.getEmailTexto().getText());
                fn.setStatus(on);
                fn.setComplementoEmdereco(this.telaCadastroFornecedor.getComplementoTexto().getText());
                fn.setEndereco(endereco);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroFornecedor.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getBody());
                this.telaCadastroFornecedor.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaFornecedor.size() + 1));
            }
        }else if(e.getSource() == this.telaCadastroFornecedor.getNovoEnd()){
            TelaCadastroEndereco a = new TelaCadastroEndereco();
            a.setVisible(true);
        }else if(e.getSource() == this.telaCadastroFornecedor.getBuscar()){
            this.telaBusca.setVisible(true);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.telaCadastroFornecedor.getEndBox().removeAllItems();
        for(int i = 0; i < DAO.ClasseDados.listaEndereco.size(); i++){
            if(DAO.ClasseDados.listaEndereco.get(i).getStatus() == "a"){
                this.telaCadastroFornecedor.getEndBox().addItem(Integer.toString(DAO.ClasseDados.listaEndereco.get(i).getId()));
            } 
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    
}
