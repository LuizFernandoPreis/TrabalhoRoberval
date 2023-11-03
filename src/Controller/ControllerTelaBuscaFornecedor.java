/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Fornecedor;
import View.TelaCadastroFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public ControllerTelaBuscaFornecedor(TelaBucaFornecedor telaBuscaFornecedor, ControllerCadFornecedor controller) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        this.controller = controller;
        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
        tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == telaBuscaFornecedor.getjButtonFiltrar()){
          System.out.println("a");
          DAO.ClasseDados.getInstance();
        if(tabela.getDataVector().size() == 0){
            for (Fornecedor fornecedor : DAO.ClasseDados.listaFornecedor) {
            tabela.addRow(new Object[] {fornecedor.getId(), fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getInscricaoEstadual(), fornecedor.getRazaoSocial()});
        }
        }
      }else if(e.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()){
                int aux = this.telaBuscaFornecedor.getjTableDados().getSelectedRow();
                TelaCadastroFornecedor tf = this.controller.telaCadastroFornecedor;
                tf.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaFornecedor.get(aux).getId()));
                tf.getCnpjTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getCnpj());
                tf.getComplementoTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getComplementoEmdereco());
                tf.getNomeTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getNome());
                tf.getRazaoSocialTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getRazaoSocial());
                tf.getInscricaoEstuadualTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getInscricaoEstadual());
                tf.getFone2Texto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getFone2());
                tf.getFoneTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getFone1());
                tf.getEndBox().setSelectedItem(Integer.toOctalString(DAO.ClasseDados.listaFornecedor.get(aux).getEndereco().getId()));
                tf.getEmailTexto().setText(DAO.ClasseDados.listaFornecedor.get(aux).getEmail());
                if(DAO.ClasseDados.listaFornecedor.get(aux).getStatus() == "a"){
                    this.controller.telaCadastroFornecedor.getStatus().setSelected(true);
                }else{
                    this.controller.telaCadastroFornecedor.getStatus().setSelected(false);
                }
                Controller.utilities.Utilities.limpaTabela(tabela);
                 this.telaBuscaFornecedor.dispose();
      }
    }
    
}
