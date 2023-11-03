/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Carteirinha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCarteirinha;


public class ControllerTelaBuscaCarteirinha implements ActionListener{
    private TelaBuscaCarteirinha telaBuscaCarteirinha;
    private ControllerCadCarteirinha controller;
    private DefaultTableModel tabela;
    public ControllerTelaBuscaCarteirinha(TelaBuscaCarteirinha telaBuscaCarteirinha, ControllerCadCarteirinha controller) {
        this.telaBuscaCarteirinha = telaBuscaCarteirinha;
        this.controller = controller;
        tabela =(DefaultTableModel) this.telaBuscaCarteirinha.getjTableDados().getModel();
        this.telaBuscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCarteirinha.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaCarteirinha.getjButtonSair().addActionListener(this);
        DAO.ClasseDados.getInstance();
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaCarteirinha.getjButtonFiltrar()){
            Controller.utilities.Utilities.limpaTabela(tabela);
            DAO.ClasseDados.getInstance();
            
            if(tabela.getDataVector().size() == 0){
                for (Carteirinha carteirinhaAtual : DAO.ClasseDados.listaCarteirinha) {
                tabela.addRow(new Object[] {carteirinhaAtual.getId(), carteirinhaAtual.getCodigoBarra(), carteirinhaAtual.getDataGeração(), carteirinhaAtual.getDataCancelamento()});
            }
            }
        }
        if(e.getSource() == this.telaBuscaCarteirinha.getjButtonCarregar()){
            int aux = this.telaBuscaCarteirinha.getjTableDados().getSelectedRow();
            this.controller.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCarteirinha.get(aux).getId()));
            this.controller.telaCadastroCarteirinha.getCodigoBarrasTexto().setText(DAO.ClasseDados.listaCarteirinha.get(aux).getCodigoBarra());
            this.controller.telaCadastroCarteirinha.getClienteBox().setSelectedItem(Integer.toString(DAO.ClasseDados.listaCarteirinha.get(aux).getCliente().getId()));
            this.controller.telaCadastroCarteirinha.getDataInicio().setText(DAO.ClasseDados.listaCarteirinha.get(aux).getDataGeração());
            this.controller.telaCadastroCarteirinha.getDataCancelamentoTexto().setText(DAO.ClasseDados.listaCarteirinha.get(aux).getDataCancelamento());
            this.telaBuscaCarteirinha.dispose();
            Controller.utilities.Utilities.limpaTabela(tabela);
           
        }
    }
}
