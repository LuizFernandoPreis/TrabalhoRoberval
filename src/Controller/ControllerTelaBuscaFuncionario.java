/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.funcionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaFuncionario;


public class ControllerTelaBuscaFuncionario implements ActionListener{
    TelaBuscaFuncionario telaBuscaFuncionario;
    DefaultTableModel tabela;
    ControllerCadFuncionario controller;
    public ControllerTelaBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario, ControllerCadFuncionario controller) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        tabela =(DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
        this.controller = controller;
        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);
        DAO.ClasseDados.getInstance();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.telaBuscaFuncionario.getjButtonFiltrar()){
           Controller.utilities.Utilities.limpaTabela(tabela);
            DAO.ClasseDados.getInstance();
            if(tabela.getDataVector().size() == 0){
                for (funcionario carteirinhaAtual : DAO.ClasseDados.listaFuncionario) {
                tabela.addRow(new Object[] {carteirinhaAtual.getId(), carteirinhaAtual.getUsuario(), carteirinhaAtual.getCpf(), carteirinhaAtual.getRg()});
            }
            }
        }else if (e.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()){
                int aux = this.telaBuscaFuncionario.getjTableDados().getSelectedRow();

                this.controller.telaCadastroFuncionario.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaFuncionario.get(aux).getId()));
                this.controller.telaCadastroFuncionario.getComplementoTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getComplementoEmdereco());
                this.controller.telaCadastroFuncionario.getCpfTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getCpf());
                this.controller.telaCadastroFuncionario.getNomeTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getNome());
                this.controller.telaCadastroFuncionario.getRgTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getRg());
                this.controller.telaCadastroFuncionario.getUsuarioTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getUsuario());
                this.controller.telaCadastroFuncionario.getSenhaTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getSenha());
                this.controller.telaCadastroFuncionario.getFoneTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getFone1());
                this.controller.telaCadastroFuncionario.getFone2Texto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getFone2());
                this.controller.telaCadastroFuncionario.getEmailTexto().setText(DAO.ClasseDados.listaFuncionario.get(aux).getEmail());
                this.controller.telaCadastroFuncionario.getEndBox().setSelectedItem(Integer.toString(DAO.ClasseDados.listaFuncionario.get(aux).getEndereco().getId()));
                if(DAO.ClasseDados.listaFuncionario.get(aux).getStatus() == "a"){
                    this.controller.telaCadastroFuncionario.getStatus().setSelected(true);
                }else{
                    this.controller.telaCadastroFuncionario.getStatus().setSelected(false);
                }
                Controller.utilities.Utilities.limpaTabela(tabela);
                 this.telaBuscaFuncionario.dispose();
        }
    }  
}
