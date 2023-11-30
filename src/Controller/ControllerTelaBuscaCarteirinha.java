/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Carteirinha;
import Service.CarteirinhaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCarteirinha;


public class ControllerTelaBuscaCarteirinha implements ActionListener{
    private TelaBuscaCarteirinha telaBuscaCarteirinha;
    private ControllerCadCarteirinha controller;
    private DefaultTableModel tabela;
    public List<Carteirinha> listaCarteirinha = new ArrayList();
    public ControllerTelaBuscaCarteirinha(TelaBuscaCarteirinha telaBuscaCarteirinha, ControllerCadCarteirinha controller) {
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
        this.telaBuscaCarteirinha = telaBuscaCarteirinha;
        this.controller = controller;
        this.telaBuscaCarteirinha.getjTFFitrar().getDocument().addDocumentListener(listener);
        tabela =(DefaultTableModel) this.telaBuscaCarteirinha.getjTableDados().getModel();
        this.telaBuscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCarteirinha.getjButtonSair().addActionListener(this);
    }
   
    
    
    public void carregar(){
        listaCarteirinha = CarteirinhaService.carregarList(this.telaBuscaCarteirinha.getjTFFitrar().getText(), this.telaBuscaCarteirinha.getBuscaChave().getSelectedItem().toString());
        Controller.utilities.Utilities.limpaTabela(tabela);
            
            if(tabela.getDataVector().size() == 0){
                for (Carteirinha carteirinhaAtual : listaCarteirinha) {
                tabela.addRow(new Object[] {carteirinhaAtual.getId(), carteirinhaAtual.getCodigoBarra(), carteirinhaAtual.getDataGeração(), carteirinhaAtual.getDataCancelamento()});
            }
            }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaCarteirinha.getjButtonCarregar()){
            int aux = this.telaBuscaCarteirinha.getjTableDados().getSelectedRow();
            int auxx = Integer.parseInt(this.telaBuscaCarteirinha.getjTableDados().getModel().getValueAt(aux, 0).toString())-1;
            this.controller.telaCadastroCarteirinha.getIdTexto().setText(Integer.toString(listaCarteirinha.get(auxx).getId()));
            this.controller.telaCadastroCarteirinha.getCodigoBarrasTexto().setText(listaCarteirinha.get(auxx).getCodigoBarra());
            this.controller.telaCadastroCarteirinha.getClienteBox().setSelectedItem(Integer.toString(listaCarteirinha.get(auxx).getCliente().getId()));
            this.controller.telaCadastroCarteirinha.getDataInicio().setText(listaCarteirinha.get(auxx).getDataGeração());
            this.controller.telaCadastroCarteirinha.getDataCancelamentoTexto().setText(listaCarteirinha.get(auxx).getDataCancelamento());
            this.controller.telaCadastroCarteirinha.getMostraCpf().setText(listaCarteirinha.get(auxx).getCliente().getCpf());
            this.controller.telaCadastroCarteirinha.getMostraNome().setText(listaCarteirinha.get(auxx).getCliente().getNome());
            this.telaBuscaCarteirinha.dispose();
            Controller.utilities.Utilities.limpaTabela(tabela);
           
        }
    }
}
