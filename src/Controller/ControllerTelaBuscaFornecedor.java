/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Endereco;
import Model.bo.Fornecedor;
import Service.EnderecoService;
import Service.FornecedorService;
import View.TelaCadastroFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBucaFornecedor;

/**
 *
 * @author luizf
 */
public class ControllerTelaBuscaFornecedor implements ActionListener{
    
    private TelaBucaFornecedor telaBuscaFornecedor;
    private DefaultTableModel tabela;
    private ControllerCadFornecedor controller;
    private List<Fornecedor> listaFornecedor = new ArrayList();
    private List<Endereco> listaEndereco = new ArrayList();
    public ControllerTelaBuscaFornecedor(TelaBucaFornecedor telaBuscaFornecedor, ControllerCadFornecedor controller) {
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
        listaEndereco = EnderecoService.carregar();
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        this.controller = controller;
        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
        this.telaBuscaFornecedor.getjTFFitrar().getDocument().addDocumentListener(listener);
        tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
    }

    public void carregar(){
        listaFornecedor = FornecedorService.carregarList(this.telaBuscaFornecedor.getjTFFitrar().getText(), this.telaBuscaFornecedor.getBuscaChave().getSelectedItem().toString());
        if(tabela.getDataVector().size() == 0){
            for (Fornecedor fornecedor : listaFornecedor) {
            tabela.addRow(new Object[] {fornecedor.getId(), fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getInscricaoEstadual(), fornecedor.getRazaoSocial()});
        }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()){
                int aux = this.telaBuscaFornecedor.getjTableDados().getSelectedRow();
                TelaCadastroFornecedor tf = this.controller.telaCadastroFornecedor;
                tf.getIdTexto().setText(Integer.toString(listaFornecedor.get(aux).getId()));
                tf.getCnpjTexto().setText(listaFornecedor.get(aux).getCnpj());
                tf.getComplementoTexto().setText(listaFornecedor.get(aux).getComplementoEmdereco());
                tf.getNomeTexto().setText(listaFornecedor.get(aux).getNome());
                tf.getRazaoSocialTexto().setText(listaFornecedor.get(aux).getRazaoSocial());
                tf.getInscricaoEstuadualTexto().setText(listaFornecedor.get(aux).getInscricaoEstadual());
                tf.getFone2Texto().setText(listaFornecedor.get(aux).getFone2());
                tf.getFoneTexto().setText(listaFornecedor.get(aux).getFone1());
                tf.getEmailTexto().setText(listaFornecedor.get(aux).getEmail());
                this.controller.telaCadastroFornecedor.getBuscaEndereco().setText(listaEndereco.get(aux).getCep());
                this.controller.telaCadastroFornecedor.getMostraBairro().setText(listaEndereco.get(aux).getBairro().getDescricao());
                this.controller.telaCadastroFornecedor.getMostraCidade().setText(listaEndereco.get(aux).getCidade().getDescricao());
                this.controller.telaCadastroFornecedor.getMostraUf().setText(listaEndereco.get(aux).getCidade().getUf());
                this.controller.endereco.setId(listaFornecedor.get(aux).getEndereco().getId());
                if(listaFornecedor.get(aux).getStatus().length() == 1){
                    this.controller.telaCadastroFornecedor.getStatus().setSelected(true);
                }else{
                    this.controller.telaCadastroFornecedor.getStatus().setSelected(false);
                }
                Controller.utilities.Utilities.limpaTabela(tabela);
                 this.telaBuscaFornecedor.dispose();
      }
    }
    
}
