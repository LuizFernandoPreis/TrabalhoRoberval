/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.utilities.Utilities;
import Model.bo.Produto;
import Service.ProdutoService;
import View.CadastroProduto;
import View.TelaCadastroBairro;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.TelaBuscaProduto;


public class ControllerCadProduto  implements ActionListener{
    
    CadastroProduto telaCadastroProduto;
    ControllerTelaBuscaProduto cotrollerTelaBuscaProduto;
    TelaBuscaProduto telaBusca;
    List<Produto> listaProduto = new ArrayList<Produto>();
    
    public ControllerCadProduto(CadastroProduto telaCadastroProduto) {
        listaProduto = ProdutoService.carregar();
        telaBusca = new TelaBuscaProduto(null,true);
        this.cotrollerTelaBuscaProduto = new ControllerTelaBuscaProduto(telaBusca,this);
        this.telaCadastroProduto = telaCadastroProduto;
        this.telaCadastroProduto.getCancelar().addActionListener(this);
        this.telaCadastroProduto.getBuscar().addActionListener(this);
        this.telaCadastroProduto.getNovo().addActionListener(this);
        this.telaCadastroProduto.getGravar().addActionListener(this);
        this.telaCadastroProduto.getSair().addActionListener(this);
        this.telaCadastroProduto.getIdTexto().setText(Integer.toString(listaProduto.size() + 1));
        this.telaCadastroProduto.getIdTexto().setEnabled(false);
        Controller.utilities.Utilities.ativa(true, this.telaCadastroProduto.getBody());
        listaProduto = ProdutoService.carregar();
    }
    
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroProduto.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroProduto.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getBody());
        } else if(e.getSource() == this.telaCadastroProduto.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroProduto.getBody());
        }else if(e.getSource() == this.telaCadastroProduto.getGravar()){
           Component componente = Utilities.testaCampos(this.telaCadastroProduto.getBody());
            if( componente instanceof JFormattedTextField || componente instanceof JTextField){
                JOptionPane.showMessageDialog(null, "Há Campos Vazios!!!");
                componente.requestFocus();
            }else{
             String on = "";
            if(this.telaCadastroProduto.getStatus().isSelected() == true){
                on = "a";
            }else if(this.telaCadastroProduto.getStatus().isSelected() == false){
                on = "";
            }
            if(Integer.parseInt(this.telaCadastroProduto.getIdTexto().getText()) > listaProduto.size()){
                Produto produto = new Produto(listaProduto.size() + 1, this.telaCadastroProduto.getDescTexto().getText(), this.telaCadastroProduto.getCodTexto().getText(),on, Float.parseFloat(this.telaCadastroProduto.getValorTexto().getText()));
                ProdutoService.adicionar(produto);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroProduto.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getBody());
                this.telaCadastroProduto.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaProduto.size() + 1));
            }else{
                Produto produto = listaProduto.get(Integer.parseInt(this.telaCadastroProduto.getIdTexto().getText())-1);
                produto.setDescricao(this.telaCadastroProduto.getDescTexto().getText());
                produto.setCodigoBarra(this.telaCadastroProduto.getCodTexto().getText());
                produto.setStatus(on);
                produto.setValor(Float.parseFloat(this.telaCadastroProduto.getValorTexto().getText()));
                ProdutoService.atualizar(produto);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroProduto.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getBody());
                this.telaCadastroProduto.getIdTexto().setText(Integer.toString(listaProduto.size() + 1));
            }
            }
            
            
        }else if(e.getSource() == this.telaCadastroProduto.getBuscar()){
            telaBusca.setVisible(true);
        }
    }
    
}
