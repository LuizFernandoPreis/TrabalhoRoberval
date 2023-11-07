package Controller;

import Model.bo.Endereco;
import Service.EnderecoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaEndereco;


public class ControllerBuscaEndereco implements ActionListener{
    TelaBuscaEndereco telaBuscaEndereco;
    ControllerCadEndereco controller;
    DefaultTableModel tabela;
    List<Endereco> listaEndereco = new ArrayList<Endereco>();
    ControllerCadCliente controllerCliente;
    int origem = 0;
    
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadEndereco controller) {
        DocumentListener listener = new DocumentListener() {
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
        this.telaBuscaEndereco = telaBuscaEndereco;
        this.controller = controller;
        this.telaBuscaEndereco.getjTFFitrar().getDocument().addDocumentListener(listener);
        this.telaBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEndereco.getjButtonSair().addActionListener(this);
        DAO.ClasseDados.getInstance();
        this.tabela = (DefaultTableModel) this.telaBuscaEndereco.getjTableDados().getModel();
    }
    
    
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadCliente controller) {
        DocumentListener listener = new DocumentListener() {
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
        this.origem = 1;
        this.telaBuscaEndereco = telaBuscaEndereco;
        this.controllerCliente = controller;
        this.telaBuscaEndereco.getjTFFitrar().getDocument().addDocumentListener(listener);
        this.telaBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEndereco.getjButtonSair().addActionListener(this);
        DAO.ClasseDados.getInstance();
        this.tabela = (DefaultTableModel) this.telaBuscaEndereco.getjTableDados().getModel();
    }
    
    
    public void carregar(){
           listaEndereco = EnderecoService.carregarList(this.telaBuscaEndereco.getjTFFitrar().getText(), this.telaBuscaEndereco.getBuscaChave().getSelectedItem().toString());
            Controller.utilities.Utilities.limpaTabela(tabela);
        if(tabela.getDataVector().size() == 0){
            for (Endereco enderecoAtual : listaEndereco) {
            tabela.addRow(new Object[] {enderecoAtual.getId(), enderecoAtual.getCep(), enderecoAtual.getLogradoura(), enderecoAtual.getStatus()});
        }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int aux = this.telaBuscaEndereco.getjTableDados().getSelectedRow();
        if(e.getSource() == this.telaBuscaEndereco.getjButtonCarregar()){
            if(this.origem == 0){
                this.controller.telaCadastroEndereco.getIdTexto().setText(Integer.toString(listaEndereco.get(aux).getId()));
                this.controller.telaCadastroEndereco.getCepTexto().setText(listaEndereco.get(aux).getCep());
                this.controller.telaCadastroEndereco.getLogradouroTexto().setText(listaEndereco.get(aux).getLogradoura());
                this.controller.telaCadastroEndereco.getUfText().setText(listaEndereco.get(aux).getCidade().getUf());
                if(listaEndereco.get(aux).getStatus().length() == 1){
                    this.controller.telaCadastroEndereco.getStatus().setSelected(true);

                }else{
                    this.controller.telaCadastroEndereco.getStatus().setSelected(false);
                }
            }else{
                this.controllerCliente.telaCadastroCliente.getBuscaEnd().setText(listaEndereco.get(aux).getCep());
                this.controllerCliente.telaCadastroCliente.getMostraBairro().setText(listaEndereco.get(aux).getBairro().getDescricao());
                this.controllerCliente.telaCadastroCliente.getMostraCidade().setText(listaEndereco.get(aux).getCidade().getDescricao());
                this.controllerCliente.telaCadastroCliente.getMostraUf().setText(listaEndereco.get(aux).getCidade().getUf());
                this.controllerCliente.endereco.setId(listaEndereco.get(aux).getId());
            }
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaEndereco.dispose();
        }
    }
    
}
