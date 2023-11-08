/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Produto;
import Service.ProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaProduto;

public class ControllerTelaBuscaProduto implements ActionListener {
    private TelaBuscaProduto telaBuscaProduto; 
    private ControllerCadProduto controller;
    DefaultTableModel tabela;
    List<Produto> listaProduto = new ArrayList<Produto>();

    public ControllerTelaBuscaProduto(TelaBuscaProduto telaBuscaProduto, ControllerCadProduto controller) {
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
        this.telaBuscaProduto = telaBuscaProduto;
        this.controller = controller;
        tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
        this.telaBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaProduto.getjButtonSair().addActionListener(this);
        
        telaBuscaProduto.getjTFFitrar().getDocument().addDocumentListener(listener);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaProduto.getjButtonCarregar()){
            int aux = this.telaBuscaProduto.getjTableDados().getSelectedRow();
            this.controller.telaCadastroProduto.getIdTexto().setText(Integer.toString(listaProduto.get(aux).getId()));
            this.controller.telaCadastroProduto.getDescTexto().setText(listaProduto.get(aux).getDescricao());
            this.controller.telaCadastroProduto.getCodTexto().setText(listaProduto.get(aux).getCodigoBarra());
            System.out.println(listaProduto.get(aux).getStatus().getClass());
            System.out.println(listaProduto.get(aux).getStatus().length());
            if(listaProduto.get(aux).getStatus().length() == 1){
                System.out.println(listaProduto.get(aux).getStatus());
                this.controller.telaCadastroProduto.getStatus().setSelected(true);
            }else{
                this.controller.telaCadastroProduto.getStatus().setSelected(false);
            }
        Controller.utilities.Utilities.limpaTabela(tabela);
        this.telaBuscaProduto.dispose();
        }
    }
    public void carregar(){
        listaProduto = ProdutoService.carregar();
        Controller.utilities.Utilities.limpaTabela(tabela);
        if(telaBuscaProduto.getjTFFitrar().getText().length() == 0){
                        if(tabela.getDataVector().size() == 0){
                    for (Produto bairroAtual : listaProduto) {
                    tabela.addRow(new Object[] {bairroAtual.getId(), bairroAtual.getDescricao()});
                }
                }
                    }else{
                        Produto bairro = new Produto();


                       
                                if(ProdutoService.carregar(telaBuscaProduto.getjTFFitrar().getText()).getDescricao() != ""){
                                    bairro = ProdutoService.carregar(telaBuscaProduto.getjTFFitrar().getText());
                                    if(bairro.getId() != 0){
                                        tabela.addRow(new Object[] {bairro.getId(), bairro.getDescricao()});
                                    }else{
                                        List<Produto> bairros = new ArrayList<>();
                                bairros = ProdutoService.carregarList(telaBuscaProduto.getjTFFitrar().getText(), telaBuscaProduto.getBuscaChave().getSelectedItem().toString());
                                for (Produto bairroAtual : bairros) {
                                    tabela.addRow(new Object[] {bairroAtual.getId(), bairroAtual.getDescricao()});
                                }
                                    }

                                }
                        }
        
    }
}
