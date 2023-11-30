/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.funcionario;
import Service.FuncionarioService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaFuncionario;


public class ControllerTelaBuscaFuncionario implements ActionListener{
    TelaBuscaFuncionario telaBuscaFuncionario;
    DefaultTableModel tabela;
    ControllerCadFuncionario controller;
    List<funcionario> listaFuncionario;
    public ControllerTelaBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario, ControllerCadFuncionario controller) {
        DocumentListener listener = new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                carregar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               carregar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                carregar();
            }
            
        };
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        tabela =(DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
        this.controller = controller;
        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);
        this.telaBuscaFuncionario.getjTFFitrar().getDocument().addDocumentListener(listener);
    }
    
    
    public void carregar(){
        listaFuncionario = FuncionarioService.carregarList(this.telaBuscaFuncionario.getjTFFitrar().getText(), this.telaBuscaFuncionario.getBuscaChave().getSelectedItem().toString());
                   Controller.utilities.Utilities.limpaTabela(tabela);
                   
            if(tabela.getDataVector().size() == 0){
                for (funcionario carteirinhaAtual : listaFuncionario) {
                tabela.addRow(new Object[] {carteirinhaAtual.getId(), carteirinhaAtual.getUsuario(), carteirinhaAtual.getCpf(), carteirinhaAtual.getRg()});
            }
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()){
                int aux = this.telaBuscaFuncionario.getjTableDados().getSelectedRow();
                int auxx = Integer.parseInt(this.telaBuscaFuncionario.getjTableDados().getModel().getValueAt(aux, 0).toString())-1;
                this.controller.endereco.setId(listaFuncionario.get(aux).getEndereco().getId());
                this.controller.telaCadastroFuncionario.getIdTexto().setText(Integer.toString(listaFuncionario.get(auxx).getId()));
                this.controller.telaCadastroFuncionario.getComplementoTexto().setText(listaFuncionario.get(auxx).getComplementoEmdereco());
                this.controller.telaCadastroFuncionario.getCpfTexto().setText(listaFuncionario.get(auxx).getCpf());
                this.controller.telaCadastroFuncionario.getNomeTexto().setText(listaFuncionario.get(auxx).getNome());
                this.controller.telaCadastroFuncionario.getRgTexto().setText(listaFuncionario.get(auxx).getRg());
                this.controller.telaCadastroFuncionario.getUsuarioTexto().setText(listaFuncionario.get(auxx).getUsuario());
                this.controller.telaCadastroFuncionario.getSenhaTexto().setText(listaFuncionario.get(auxx).getSenha());
                this.controller.telaCadastroFuncionario.getFoneTexto().setText(listaFuncionario.get(auxx).getFone1());
                this.controller.telaCadastroFuncionario.getFone2Texto().setText(listaFuncionario.get(auxx).getFone2());
                this.controller.telaCadastroFuncionario.getEmailTexto().setText(listaFuncionario.get(auxx).getEmail());
                this.controller.telaCadastroFuncionario.getBuscaEnd().setText(listaFuncionario.get(auxx).getEndereco().getCep());
                this.controller.telaCadastroFuncionario.getMostraBairro().setText(listaFuncionario.get(auxx).getEndereco().getBairro().getDescricao());
                this.controller.telaCadastroFuncionario.getMostraCidade().setText(listaFuncionario.get(auxx).getEndereco().getCidade().getDescricao());
                this.controller.telaCadastroFuncionario.getMostraUf().setText(listaFuncionario.get(auxx).getEndereco().getCidade().getUf());
                if(listaFuncionario.get(auxx).getStatus().length() == 1){
                    this.controller.telaCadastroFuncionario.getStatus().setSelected(true);
                }else{
                    this.controller.telaCadastroFuncionario.getStatus().setSelected(false);
                }
                Controller.utilities.Utilities.limpaTabela(tabela);
                 this.telaBuscaFuncionario.dispose();
        }
    }  
}
