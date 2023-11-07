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
private DefaultTableModel tabela;
private List<Cliente> listaCliente = new ArrayList();
    public ControllerTelaBuscaCliente(TelaBuscaCliente telaBuscaCliente, ControllerCadCliente controller) {
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
        this.controller = controller;
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

                 this.controller.telaCadastroCliente.getIdTexto().setText(Integer.toString(aux+1));
                 this.controller.telaCadastroCliente.getComplementoTexto().setText(listaCliente.get(aux).getComplementoEmdereco());
                 this.controller.telaCadastroCliente.getCpfTexto().setText(listaCliente.get(aux).getCpf());
                 this.controller.telaCadastroCliente.getNomeTexto().setText(listaCliente.get(aux).getNome());
                 this.controller.telaCadastroCliente.getRgTexto().setText(listaCliente.get(aux).getRg());
                 this.controller.telaCadastroCliente.getMatriculaTexto().setText(listaCliente.get(aux).getMatricula());
                 this.controller.telaCadastroCliente.getDataNascimentoTexto().setText(listaCliente.get(aux).getDataNascimento());
                 this.controller.telaCadastroCliente.getFoneTexto().setText(listaCliente.get(aux).getFone1());
                 this.controller.telaCadastroCliente.getFone2Texto().setText(listaCliente.get(aux).getFone2());
                 this.controller.telaCadastroCliente.getEmailTexto().setText(listaCliente.get(aux).getEmail());
                 this.controller.telaCadastroCliente.getBuscaEnd().setText(listaCliente.get(aux).getEndereco().getCep());
                 this.controller.telaCadastroCliente.getMostraBairro().setText(listaCliente.get(aux).getEndereco().getBairro().getDescricao());
                 this.controller.telaCadastroCliente.getMostraCidade().setText(listaCliente.get(aux).getEndereco().getCidade().getDescricao());
                 this.controller.telaCadastroCliente.getMostraUf().setText(listaCliente.get(aux).getEndereco().getCidade().getUf());
                 this.controller.endereco.setId(listaCliente.get(aux).getEndereco().getId());
                  if(listaCliente.get(aux).getStatus().length() == 1){
                this.controller.telaCadastroCliente.getStatus().setSelected(true);
            }else{
                this.controller.telaCadastroCliente.getStatus().setSelected(false);
            }
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaCliente.dispose();
       }
    }
}
