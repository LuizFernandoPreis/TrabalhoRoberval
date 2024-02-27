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
    ControllerCadFornecedor controllerFornecedor;
    ControllerCadFuncionario controllerFuncionario;
    int origem = 0;
    
    
    
    
    
    
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadEndereco controller) {
       inicia(telaBuscaEndereco);
        this.controller = controller;
    }
    
    
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadCliente controller) {
       inicia(telaBuscaEndereco);
        this.controllerCliente = controller;
       this.origem = 1;
    }
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadFornecedor controller) {
       inicia(telaBuscaEndereco);
        this.controllerFornecedor = controller;
       this.origem = 2;
    }
    public ControllerBuscaEndereco(TelaBuscaEndereco telaBuscaEndereco, ControllerCadFuncionario controller) {
       inicia(telaBuscaEndereco);
        this.controllerFuncionario = controller;
       this.origem = 3;
    }
    
    
    
    
    
    
    
    
    
    public void inicia(TelaBuscaEndereco telaBuscaEndereco){
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
        this.telaBuscaEndereco = telaBuscaEndereco;;
        this.telaBuscaEndereco.getjTFFitrar().getDocument().addDocumentListener(listener);
        this.telaBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEndereco.getjButtonSair().addActionListener(this);
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
        int auxx = Integer.parseInt(this.telaBuscaEndereco.getjTableDados().getModel().getValueAt(aux, 0).toString())-1;
        if(e.getSource() == this.telaBuscaEndereco.getjButtonCarregar()){
            switch(this.origem){
                case 0:
                        this.controller.telaCadastroEndereco.getIdTexto().setText(Integer.toString(listaEndereco.get(auxx).getId()));
                        this.controller.telaCadastroEndereco.getCepTexto().setText(listaEndereco.get(auxx).getCep());
                        this.controller.telaCadastroEndereco.getLogradouroTexto().setText(listaEndereco.get(auxx).getLogradoura());
                        this.controller.telaCadastroEndereco.getUfText().setText(listaEndereco.get(auxx).getCidade().getUf());
                        this.controller.telaCadastroEndereco.getBairroBox().setSelectedIndex(listaEndereco.get(auxx).getBairro().getId()-1);
                        this.controller.telaCadastroEndereco.getCidadeBox().setSelectedIndex(listaEndereco.get(auxx).getCidade().getId()-1);
                        if(listaEndereco.get(auxx).getStatus().length() == 1){
                            this.controller.telaCadastroEndereco.getStatus().setSelected(true);

                         }else{
                            this.controller.telaCadastroEndereco.getStatus().setSelected(false);
                        }
                    break;
                case 1:
                        this.controllerCliente.telaCadastroCliente.getBuscaEnd().setText(listaEndereco.get(auxx).getCep());
                        this.controllerCliente.telaCadastroCliente.getMostraBairro().setText(listaEndereco.get(auxx).getBairro().getDescricao());
                        this.controllerCliente.telaCadastroCliente.getMostraCidade().setText(listaEndereco.get(auxx).getCidade().getDescricao());
                        this.controllerCliente.telaCadastroCliente.getMostraUf().setText(listaEndereco.get(auxx).getCidade().getUf());
                        this.controllerCliente.endereco.setId(listaEndereco.get(auxx).getId());
                    break;
                case 2:
                        this.controllerFornecedor.telaCadastroFornecedor.getBuscaEndereco().setText(listaEndereco.get(auxx).getCep());
                        this.controllerFornecedor.telaCadastroFornecedor.getMostraBairro().setText(listaEndereco.get(auxx).getBairro().getDescricao());
                        this.controllerFornecedor.telaCadastroFornecedor.getMostraCidade().setText(listaEndereco.get(auxx).getCidade().getDescricao());
                        this.controllerFornecedor.telaCadastroFornecedor.getMostraUf().setText(listaEndereco.get(auxx).getCidade().getUf());
                        this.controllerFornecedor.endereco.setId(listaEndereco.get(auxx).getId());
                    break;
                case 3:
                        this.controllerFuncionario.telaCadastroFuncionario.getBuscaEndecero().setText(listaEndereco.get(auxx).getCep());
                        this.controllerFuncionario.telaCadastroFuncionario.getMostraBairro().setText(listaEndereco.get(auxx).getBairro().getDescricao());
                        this.controllerFuncionario.telaCadastroFuncionario.getMostraCidade().setText(listaEndereco.get(auxx).getCidade().getDescricao());
                        this.controllerFuncionario.telaCadastroFuncionario.getMostraUf().setText(listaEndereco.get(auxx).getCidade().getUf());
                        this.controllerFuncionario.endereco.setId(listaEndereco.get(auxx).getId());
                    break;
            }
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaEndereco.dispose();
        }if(e.getSource()== this.telaBuscaEndereco.getjButtonSair()){
            this.telaBuscaEndereco.dispose();
      }
    }
    
}
