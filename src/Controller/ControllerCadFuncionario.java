
package Controller;

import Controller.utilities.Utilities;
import Model.bo.Endereco;
import Model.bo.funcionario;
import Service.FuncionarioService;
import View.TelaCadastroEndereco;
import View.TelaCadastroFuncionario;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.TelaBuscaFuncionario;

public class ControllerCadFuncionario implements ActionListener, FocusListener{TelaCadastroFuncionario telaCadastroFuncionario;
    ControllerTelaBuscaFuncionario controller;
    TelaBuscaFuncionario telaBusca;
    List<funcionario> listaFuncionario;
    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        listaFuncionario = FuncionarioService.carregar();
        this.telaCadastroFuncionario = telaCadastroFuncionario;
        this.telaBusca = new TelaBuscaFuncionario(null, true);
        this.controller = new ControllerTelaBuscaFuncionario(telaBusca, this);
        this.telaCadastroFuncionario.getCancelar().addActionListener(this);
        this.telaCadastroFuncionario.getBuscar().addActionListener(this);
        this.telaCadastroFuncionario.getNovo().addActionListener(this);
        this.telaCadastroFuncionario.getGravar().addActionListener(this);
        this.telaCadastroFuncionario.getSair().addActionListener(this);
        this.telaCadastroFuncionario.getNewbtn().addActionListener(this);
        this.telaCadastroFuncionario.getBuscarEnd().addActionListener(this);
        Controller.utilities.Utilities.ativa(true, this.telaCadastroFuncionario.getBody());
        this.telaCadastroFuncionario.getIdTexto().setText(Integer.toString(listaFuncionario.size() + 1));
        this.telaCadastroFuncionario.getIdTexto().setEnabled(false);
        
    }
    
   Endereco endereco = new Endereco();
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroFuncionario.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroFuncionario.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroFuncionario.getBody());
        } else if(e.getSource() == this.telaCadastroFuncionario.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroFuncionario.getBody());
        }else if(e.getSource() == this.telaCadastroFuncionario.getGravar()){
            Component componente = Utilities.testaCampos(this.telaCadastroFuncionario.getBody());
            if( componente instanceof JFormattedTextField || componente instanceof JTextField){
                JOptionPane.showMessageDialog(null, "Há Campos Vazios!!!");
                componente.requestFocus();
            }else{
           String on = "";
            if(this.telaCadastroFuncionario.getStatus().isSelected() == true){
                on = "a";
            }else if(this.telaCadastroFuncionario.getStatus().isSelected() == false){
                on = "";
            }
               if(Integer.parseInt(this.telaCadastroFuncionario.getIdTexto().getText()) > listaFuncionario.size()){
                   funcionario Funcionario = new funcionario(this.telaCadastroFuncionario.getCpfTexto().getText(),this.telaCadastroFuncionario.getRgTexto().getText(),this.telaCadastroFuncionario.getUsuarioTexto().getText(),this.telaCadastroFuncionario.getSenhaTexto().getText(),DAO.ClasseDados.listaFuncionario.size() + 1,this.telaCadastroFuncionario.getNomeTexto().getText(), this.telaCadastroFuncionario.getFoneTexto().getText(),this.telaCadastroFuncionario.getFone2Texto().getText(), this.telaCadastroFuncionario.getEmailTexto().getText(), 
                     on,this.telaCadastroFuncionario.getComplementoTexto().getText(), endereco);
                FuncionarioService.adicionar(Funcionario);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroFuncionario.getBody());
                Controller.utilities.Utilities.limpaComponentes( true, this.telaCadastroFuncionario.getBody());
                this.telaCadastroFuncionario.getIdTexto().setText(Integer.toString(listaFuncionario.size() + 1));
               }else if(listaFuncionario.contains(listaFuncionario.get(Integer.parseInt(this.telaCadastroFuncionario.getIdTexto().getText())-1))){
                   funcionario F =  listaFuncionario.get(Integer.parseInt(this.telaCadastroFuncionario.getIdTexto().getText()) - 1);
                   F.setCpf(this.telaCadastroFuncionario.getCpfTexto().getText());
                   F.setRg(this.telaCadastroFuncionario.getRgTexto().getText());
                   F.setUsuario(this.telaCadastroFuncionario.getUsuarioTexto().getText());
                   F.setSenha(this.telaCadastroFuncionario.getSenhaTexto().getText());
                   F.setNome(this.telaCadastroFuncionario.getNomeTexto().getText());
                   F.setFone1(this.telaCadastroFuncionario.getFoneTexto().getText());
                   F.setFone2(this.telaCadastroFuncionario.getFone2Texto().getText());
                   F.setEmail(this.telaCadastroFuncionario.getEmailTexto().getText());
                   F.setComplementoEmdereco(this.telaCadastroFuncionario.getComplementoTexto().getText());
                   F.setEndereco(endereco);
                   F.setStatus(on);
                   FuncionarioService.atualizar(F);
                   Controller.utilities.Utilities.ativa(true, this.telaCadastroFuncionario.getBody());
                   Controller.utilities.Utilities.limpaComponentes( true, this.telaCadastroFuncionario.getBody());
                   this.telaCadastroFuncionario.getIdTexto().setText(Integer.toString(listaFuncionario.size() + 1));
               }
            }
            
               
               
             
        }else if(e.getSource() == this.telaCadastroFuncionario.getBuscar()){
            telaBusca.setVisible(true);
        }else if(e.getSource() == this.telaCadastroFuncionario.getNewbtn()){
            TelaCadastroEndereco a = new TelaCadastroEndereco();
            a.setVisible(true);
        }else if(e.getSource() == this.telaCadastroFuncionario.getBuscarEnd()){
            view.TelaBuscaEndereco tela= new view.TelaBuscaEndereco(null, true);
            ControllerBuscaEndereco controller = new ControllerBuscaEndereco(tela, this);
            tela.setVisible(true);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    
}
