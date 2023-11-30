/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Cliente;
import Service.ClienteService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCliente;


public class ControllerTelaBuscaCliente implements ActionListener{
public TelaBuscaCliente telaBuscaCliente;
private ControllerCadCliente controller;
private ControllerCadCarteirinha controllerCarteirinha;
private DefaultTableModel tabela;
private List<Cliente> listaCliente = new ArrayList();
int origem = 0;


 public ControllerTelaBuscaCliente(TelaBuscaCliente telaBuscaCliente, ControllerCadCarteirinha controller) {
     origem = 1;
     this.controllerCarteirinha = controller;
     inicia(telaBuscaCliente);
 }


    public ControllerTelaBuscaCliente(TelaBuscaCliente telaBuscaCliente, ControllerCadCliente controller) {
        inicia(telaBuscaCliente);
        this.controller = controller;
       
    }
    
    
    public void inicia(TelaBuscaCliente telaBuscaCliente){
        
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
        this.telaBuscaCliente = telaBuscaCliente;
        tabela =(DefaultTableModel) this.telaBuscaCliente.getjTableDados().getModel();
        this.telaBuscaCliente.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCliente.getjTFFitrar().getDocument().addDocumentListener(listener);
        this.telaBuscaCliente.getjButtonSair().addActionListener(this);
    }
    
    
    public void carregar(){
        Controller.utilities.Utilities.limpaTabela(tabela);
         listaCliente = ClienteService.carregarList(this.telaBuscaCliente.getjTFFitrar().getText(),this.telaBuscaCliente.getBuscaChave().getSelectedItem().toString());
                if(tabela.getDataVector().size() == 0){
            for (Cliente clienteAtual : listaCliente) {
            tabela.addRow(new Object[] {clienteAtual.getId(), clienteAtual.getMatricula(),clienteAtual.getCpf(), clienteAtual.getNome()});
          }
        }
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaCliente.getjButtonCarregar()){
                 int aux = this.telaBuscaCliente.getjTableDados().getSelectedRow();
                 int auxx = Integer.parseInt(this.telaBuscaCliente.getjTableDados().getModel().getValueAt(aux, 0).toString())-1;
                 if(origem ==0){
                        this.controller.telaCadastroCliente.getIdTexto().setText(Integer.toString(auxx+1));
                        this.controller.telaCadastroCliente.getComplementoTexto().setText(listaCliente.get(auxx).getComplementoEmdereco());
                        this.controller.telaCadastroCliente.getCpfTexto().setText(listaCliente.get(auxx).getCpf());
                        this.controller.telaCadastroCliente.getNomeTexto().setText(listaCliente.get(auxx).getNome());
                        this.controller.telaCadastroCliente.getRgTexto().setText(listaCliente.get(auxx).getRg());
                        this.controller.telaCadastroCliente.getMatriculaTexto().setText(listaCliente.get(auxx).getMatricula());
                        this.controller.telaCadastroCliente.getDataNascimentoTexto().setText(listaCliente.get(auxx).getDataNascimento());
                        this.controller.telaCadastroCliente.getFoneTexto().setText(listaCliente.get(auxx).getFone1());
                        this.controller.telaCadastroCliente.getFone2Texto().setText(listaCliente.get(auxx).getFone2());
                        this.controller.telaCadastroCliente.getEmailTexto().setText(listaCliente.get(auxx).getEmail());
                        this.controller.telaCadastroCliente.getBuscaEnd().setText(listaCliente.get(auxx).getEndereco().getCep());
                        this.controller.telaCadastroCliente.getMostraBairro().setText(listaCliente.get(auxx).getEndereco().getBairro().getDescricao());
                        this.controller.telaCadastroCliente.getMostraCidade().setText(listaCliente.get(auxx).getEndereco().getCidade().getDescricao());
                        this.controller.telaCadastroCliente.getMostraUf().setText(listaCliente.get(auxx).getEndereco().getCidade().getUf());
                        this.controller.endereco.setId(listaCliente.get(auxx).getEndereco().getId());
                         if(listaCliente.get(auxx).getStatus().length() == 1){
                       this.controller.telaCadastroCliente.getStatus().setSelected(true);
                   }else{
                       this.controller.telaCadastroCliente.getStatus().setSelected(false);
                   }
                 }else{
                     this.controllerCarteirinha.telaCadastroCarteirinha.getMostraCpf().setText(listaCliente.get(auxx).getCpf());
                     this.controllerCarteirinha.telaCadastroCarteirinha.getMostraNome().setText(listaCliente.get(auxx).getNome());
                     this.controllerCarteirinha.telaCadastroCarteirinha.getClienteBox().setSelectedItem(""+listaCliente.get(auxx).getId());
                 }
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaCliente.dispose();
       }
    }
}
