/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCliente;


public class ControllerTelaBuscaCliente implements ActionListener{
public TelaBuscaCliente telaBuscaCliente;
private ControllerCadCliente controller;
private DefaultTableModel tabela;
    public ControllerTelaBuscaCliente(TelaBuscaCliente telaBuscaCliente, ControllerCadCliente controller) {
        this.telaBuscaCliente = telaBuscaCliente;
        this.controller = controller;
        tabela =(DefaultTableModel) this.telaBuscaCliente.getjTableDados().getModel();
        this.telaBuscaCliente.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCliente.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaCliente.getjButtonSair().addActionListener(this);
        DAO.ClasseDados.getInstance();
    }
    
@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaCliente.getjButtonFiltrar()){
            DAO.ClasseDados.getInstance();
                if(tabela.getDataVector().size() == 0){
            for (Cliente clienteAtual : DAO.ClasseDados.listaCliente) {
            tabela.addRow(new Object[] {clienteAtual.getId(), clienteAtual.getMatricula(),clienteAtual.getCpf(), clienteAtual.getNome()});
          }
        }
       }else if(e.getSource() == this.telaBuscaCliente.getjButtonCarregar()){
                 int aux = this.telaBuscaCliente.getjTableDados().getSelectedRow();

                 this.controller.telaCadastroCliente.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCliente.get(aux).getId()));
                 this.controller.telaCadastroCliente.getComplementoTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getComplementoEmdereco());
                 this.controller.telaCadastroCliente.getCpfTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getCpf());
                 this.controller.telaCadastroCliente.getNomeTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getNome());
                 this.controller.telaCadastroCliente.getRgTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getRg());
                 this.controller.telaCadastroCliente.getMatriculaTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getMatricula());
                 this.controller.telaCadastroCliente.getDataNascimentoTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getDataNascimento());
                 this.controller.telaCadastroCliente.getFoneTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getFone1());
                 this.controller.telaCadastroCliente.getFone2Texto().setText(DAO.ClasseDados.listaCliente.get(aux).getFone2());
                 this.controller.telaCadastroCliente.getEmailTexto().setText(DAO.ClasseDados.listaCliente.get(aux).getEmail());
                  if(DAO.ClasseDados.listaCliente.get(aux).getStatus() == "a"){
                this.controller.telaCadastroCliente.getStatus().setSelected(true);
            }else{
                this.controller.telaCadastroCliente.getStatus().setSelected(false);
            }
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaCliente.dispose();
       }
    }
}
