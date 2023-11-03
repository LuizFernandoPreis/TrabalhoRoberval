
package Controller;

import Model.bo.Carteirinha;
import Model.bo.Cliente;
import View.TelaCadastroBairro;
import View.TelaCadastroCarteirinha;
import View.TelaCadastroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class ControllerCadCarteirinha  implements ActionListener, FocusListener{
    
    TelaCadastroCarteirinha telaCadastroCarteirinha;
    view.TelaBuscaCarteirinha telaBusca; 
    ControllerTelaBuscaCarteirinha controller;
    public ControllerCadCarteirinha(TelaCadastroCarteirinha telaCadastroCarteirinha) {
        this.telaCadastroCarteirinha = telaCadastroCarteirinha;
        this.telaBusca = new view.TelaBuscaCarteirinha(null,true);
        controller = new ControllerTelaBuscaCarteirinha(telaBusca,this);
        this.telaCadastroCarteirinha.getCancelar().addActionListener(this);
        this.telaCadastroCarteirinha.getBuscar().addActionListener(this);
        this.telaCadastroCarteirinha.getNovo().addActionListener(this);
        this.telaCadastroCarteirinha.getGravar().addActionListener(this);
        this.telaCadastroCarteirinha.getSair().addActionListener(this);
        this.telaCadastroCarteirinha.getNovoCliente().addActionListener(this);
        this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCliente.size() + 1));
        this.telaCadastroCarteirinha.getIdTexto().setEnabled(false);
        this.telaCadastroCarteirinha.getClienteBox().addFocusListener(this);
        for(int i = 0; i < DAO.ClasseDados.listaCliente.size();i++){
            if(DAO.ClasseDados.listaCliente.get(i).getStatus() == "a"){
                 this.telaCadastroCarteirinha.getClienteBox().addItem(Integer.toString(DAO.ClasseDados.listaCliente.get(i).getId()));
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
            if(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText()) > DAO.ClasseDados.listaCarteirinha.size()){
                Cliente cliente = DAO.ClasseDados.listaCliente.get(Integer.parseInt(this.telaCadastroCarteirinha.getClienteBox().getSelectedItem().toString() )-1);
                Carteirinha carteirinha = new Carteirinha(DAO.ClasseDados.listaCarteirinha.size() + 1, this.telaCadastroCarteirinha.getCodigoBarrasTexto().getText(), this.telaCadastroCarteirinha.getDataInicio().getText(),this.telaCadastroCarteirinha.getDataCancelamentoTexto().getText(), cliente);
                DAO.ClasseDados.listaCarteirinha.add(carteirinha);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getBody());
                this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCarteirinha.size() + 1));
            }else if(DAO.ClasseDados.listaCarteirinha.contains(DAO.ClasseDados.listaCarteirinha.get(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText())-1))){
                Cliente cl = DAO.ClasseDados.listaCliente.get(this.telaCadastroCarteirinha.getClienteBox().getSelectedIndex());
                Carteirinha ct = DAO.ClasseDados.listaCarteirinha.get(Integer.parseInt(this.telaCadastroCarteirinha.getIdTexto().getText()) - 1);
                ct.setCodigoBarra(this.telaCadastroCarteirinha.getCodigoBarrasTexto().getText());
                ct.setDataCancelamento(this.telaCadastroCarteirinha.getDataCancelamentoTexto().getText());
                ct.setDataGeração(this.telaCadastroCarteirinha.getDataInicio().getText());
                ct.setCliente(cl);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroCarteirinha.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroCarteirinha.getBody());
                this.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCarteirinha.size() + 1));
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
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.telaCadastroCarteirinha.getClienteBox().removeAllItems();
        for(int i = 0; i < DAO.ClasseDados.listaCliente.size();i++){
            if(DAO.ClasseDados.listaCliente.get(i).getStatus() == "a"){
            this.telaCadastroCarteirinha.getClienteBox().addItem(Integer.toString(DAO.ClasseDados.listaCliente.get(i).getId()));
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    
}
