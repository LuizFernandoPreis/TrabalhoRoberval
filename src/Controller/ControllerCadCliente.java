 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Cliente;
import Model.bo.Endereco;
import Service.ClienteService;
import Service.EnderecoService;
import View.TelaCadastroCliente;
import View.TelaCadastroEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import view.TelaBuscaCliente;
import view.TelaBuscaEndereco;


public class ControllerCadCliente implements ActionListener, FocusListener{
    
    TelaCadastroCliente telaCadastroCliente;
    view.TelaBuscaCliente telaBusca;
     ControllerTelaBuscaCliente controller;
    private  List<Cliente> listaCliente = new ArrayList();
    private  List<Endereco> listaEndereco = new ArrayList();
    public ControllerCadCliente(TelaCadastroCliente telaCadastroCliente) {
        listaCliente = ClienteService.carregar();
        listaEndereco = EnderecoService.carregar();
        this.telaCadastroCliente = telaCadastroCliente;
        this.telaBusca = new TelaBuscaCliente(null, true);
        this.controller = new ControllerTelaBuscaCliente(telaBusca,this);
        this.telaCadastroCliente.getCancelar().addActionListener(this);
        this.telaCadastroCliente.getBuscar().addActionListener(this);
        this.telaCadastroCliente.getNovo().addActionListener(this);
        this.telaCadastroCliente.getGravar().addActionListener(this);
        this.telaCadastroCliente.getSair().addActionListener(this);
        this.telaCadastroCliente.getNewButton().addActionListener(this);
        this.telaCadastroCliente.getBuscarEnd().addActionListener(this);
        Controller.utilities.Utilities.ativa(true, this.telaCadastroCliente.getBody());
        this.telaCadastroCliente.getIdTexto().setText(Integer.toString(listaCliente.size() + 1));
        this.telaCadastroCliente.getIdTexto().setEnabled(false);
    }
    
   Endereco endereco = new Endereco();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroCliente.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroCliente.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCliente.getBody());
        } else if(e.getSource() == this.telaCadastroCliente.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroCliente.getBody());
        }else if(e.getSource() == this.telaCadastroCliente.getGravar()){
            
            String on = "";
            if(this.telaCadastroCliente.getStatus().isSelected() == true){
                on = "a";
            }else if(this.telaCadastroCliente.getStatus().isSelected() == false){
                on = "";
            }
            endereco.setCep(this.telaCadastroCliente.getCpfTexto().getText());
            
           
            
             if(Integer.parseInt(this.telaCadastroCliente.getIdTexto().getText()) > listaCliente.size()){
                 
                 Cliente cliente = new Cliente(this.telaCadastroCliente.getCpfTexto().getText(), this.telaCadastroCliente.getRgTexto().getText(),
                    this.telaCadastroCliente.getMatriculaTexto().getText(),this.telaCadastroCliente.getDataNascimentoTexto().getText(),
                    Integer.parseInt(this.telaCadastroCliente.getIdTexto().getText()), this.telaCadastroCliente.getNomeTexto().getText(), this.telaCadastroCliente.getFoneTexto().getText(), 
                    this.telaCadastroCliente.getFone2Texto().getText(),this.telaCadastroCliente.getEmailTexto().getText(), on,this.telaCadastroCliente.getComplementoTexto().getText(), endereco );
                cliente.setCpf(this.telaCadastroCliente.getCpfTexto().getText());
                 ClienteService.adicionar(cliente);
            Controller.utilities.Utilities.ativa(true, this.telaCadastroCliente.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCliente.getBody());
            this.telaCadastroCliente.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCliente.size() + 1));
            this.telaCadastroCliente.getIdTexto().setEnabled(false);
            
             
             }else if(DAO.ClasseDados.listaCliente.contains(listaCliente.get(Integer.parseInt(this.telaCadastroCliente.getIdTexto().getText())-1))){
                 
            Cliente cl = listaCliente.get(Integer.parseInt(this.telaCadastroCliente.getIdTexto().getText()) - 1);
            cl.setNome(this.telaCadastroCliente.getNomeTexto().getText());
           cl.setCpf(this.telaCadastroCliente.getCpfTexto().getText());
           cl.setDataNascimento(this.telaCadastroCliente.getDataNascimentoTexto().getText());
           cl.setComplementoEmdereco(this.telaCadastroCliente.getComplementoTexto().getText());
           cl.setMatricula(this.telaCadastroCliente.getMatriculaTexto().getText());
           cl.setRg(this.telaCadastroCliente.getRgTexto().getText());
           cl.setFone1(this.telaCadastroCliente.getFoneTexto().getText());
           cl.setFone2(this.telaCadastroCliente.getFone2Texto().getText());
           cl.setEmail(this.telaCadastroCliente.getEmailTexto().getText());
           cl.setEndereco(endereco);
           cl.setStatus(on);
           ClienteService.atualizar(cl);
           Controller.utilities.Utilities.ativa(true, this.telaCadastroCliente.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCliente.getBody());
            this.telaCadastroCliente.getIdTexto().setText(Integer.toString(listaCliente.size() + 1));
            this.telaCadastroCliente.getIdTexto().setEnabled(false);
        }
            
        }else if(e.getSource() == this.telaCadastroCliente.getNewButton()){
            TelaCadastroEndereco end = new TelaCadastroEndereco();
            end.setVisible(true);
        }else if(e.getSource() == this.telaCadastroCliente.getBuscar()){
            this.telaBusca.setVisible(true);
        }else if(e.getSource() == this.telaCadastroCliente.getBuscarEnd()){
           
            view.TelaBuscaEndereco end = new view.TelaBuscaEndereco(null,true);
            ControllerBuscaEndereco controller = new ControllerBuscaEndereco(end,this);
            end.setVisible(true);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    
}

