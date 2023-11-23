
package Controller;

import Controller.utilities.Utilities;
import Model.bo.Carteirinha;
import Model.bo.Cliente;
import Service.CarteirinhaService;
import Service.ClienteService;
import View.TelaCadastroBairro;
import View.TelaCadastroCarteirinha;
import View.TelaCadastroCliente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.TelaBuscaCliente;


public class ControllerCadCarteirinha  implements ActionListener, FocusListener{
    
    TelaCadastroCarteirinha telaCadastroCarteirinha;
    view.TelaBuscaCarteirinha telaBusca; 
    ControllerTelaBuscaCarteirinha controller;
    List<Carteirinha> listaCarteirinha = new ArrayList();
    public List<Cliente> listaCliente = new ArrayList();
    public ControllerCadCarteirinha(TelaCadastroCarteirinha telaCadastroCarteirinha) {
        listaCliente = ClienteService.carregar();
        this.telaCadastroCarteirinha = telaCadastroCarteirinha;
        this.telaBusca = new view.TelaBuscaCarteirinha(null,true);
        controller = new ControllerTelaBuscaCarteirinha(telaBusca,this);
        this.telaCadastroCarteirinha.getCancelar().addActionListener(this);
        this.telaCadastroCarteirinha.getBuscar().addActionListener(this);
        this.telaCadastroCarteirinha.getNovo().addActionListener(this);
        this.telaCadastroCarteirinha.getGravar().addActionListener(this);
        this.telaCadastroCarteirinha.getSair().addActionListener(this);
        this.telaCadastroCarteirinha.getNovoCliente().addActionListener(this);
        this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(listaCliente.size() + 1));
        this.telaCadastroCarteirinha.getIdTexto().setEnabled(false);
        this.telaCadastroCarteirinha.getClienteBox().addActionListener(this);
        this.telaCadastroCarteirinha.getDataInicio().addActionListener(this);
        for(int i = 0; i < listaCliente.size();i++){
            if(listaCliente.get(i).getStatus().length() == 1){
                 this.telaCadastroCarteirinha.getClienteBox().addItem(Integer.toString(listaCliente.get(i).getId()));
            }
           
        }
        
        Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
    }
    
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroCarteirinha.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getBody());
        } else if(e.getSource() == this.telaCadastroCarteirinha.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroCarteirinha.getBody());
        }else if(e.getSource() == this.telaCadastroCarteirinha.getGravar()){
            Component componente = Utilities.testaCampos(this.telaCadastroCarteirinha.getBody());
            if( componente instanceof JFormattedTextField || componente instanceof JTextField){
                JOptionPane.showMessageDialog(null, "Há Campos Vazios!!!");
                componente.requestFocus();
            }else{
                  
            if(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText()) > listaCarteirinha.size()){
                Cliente cliente = new Cliente();
                cliente.setId(this.telaCadastroCarteirinha.getClienteBox().getSelectedIndex()+1);
                Carteirinha carteirinha = new Carteirinha(listaCarteirinha.size() + 1, this.telaCadastroCarteirinha.getCodigoBarrasTexto().getText(), this.telaCadastroCarteirinha.getDataInicio().getText(),this.telaCadastroCarteirinha.getDataCancelamentoTexto().getText(), cliente);
                
                
                CarteirinhaService.adicionar(carteirinha);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getBody());
                this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCarteirinha.size() + 1));
            }else if(listaCarteirinha.contains(listaCarteirinha.get(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText())-1))){
                
                
                Cliente cl = listaCliente.get(this.telaCadastroCarteirinha.getClienteBox().getSelectedIndex());
                Carteirinha ct = listaCarteirinha.get(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText()) - 1);
                ct.setCodigoBarra(this.telaCadastroCarteirinha.getCodigoBarrasTexto().getText());
                ct.setDataCancelamento(this.telaCadastroCarteirinha.getDataCancelamentoTexto().getText());
                ct.setDataGeração(this.telaCadastroCarteirinha.getDataInicio().getText());
                ct.setCliente(cl);
                CarteirinhaService.atualizar(ct);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getBody());
                this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCarteirinha.size() + 1));
            }
            }
          
            
            
        }else if(e.getSource() == this.telaCadastroCarteirinha.getBuscar()){
            this.telaCadastroCarteirinha.getClienteBox().removeAllItems();
            for(int i = 0; i < DAO.ClasseDados.listaCliente.size();i++){
            this.telaCadastroCarteirinha.getClienteBox().addItem(Integer.toString(DAO.ClasseDados.listaCliente.get(i).getId()));
        }
            telaBusca.setVisible(true);
        }else if(e.getSource() == this.telaCadastroCarteirinha.getNovoCliente()){
            TelaCadastroCliente tcc = new TelaCadastroCliente();
            tcc.setVisible(true);
        }else if(e.getSource() == this.telaCadastroCarteirinha.getBuscaCliente()){
            System.out.println("asd");
        }else if (e.getSource() == this.telaCadastroCarteirinha.getClienteBox()){
            Cliente cl = new Cliente();
            for(int i = 0; i < listaCliente.size(); i++){
                if(listaCliente.get(i).getId() == Integer.parseInt(this.telaCadastroCarteirinha.getClienteBox().getSelectedItem().toString()) ){
                    cl = listaCliente.get(i);
                }
            }
            
        this.telaCadastroCarteirinha.getMostraNome().setText(cl.getNome());
        this.telaCadastroCarteirinha.getMostraCpf().setText(cl.getCpf());
        }else if(e.getSource() == this.telaCadastroCarteirinha.getDataInicio()){
            String txt = this.telaCadastroCarteirinha.getDataInicio().getText();
            int aux = Integer.parseInt(txt.substring(8, 10)) +1;
            String finaltxt = txt.substring(0, 8) + aux;
            this.telaCadastroCarteirinha.getDataCancelamentoTexto().setText(finaltxt);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    
}
