
package Controller;

import Model.bo.Cidade;
import Service.CidadeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCidade;


public class ControllerTelaBuscaCidade implements ActionListener{
    private TelaBuscaCidade telaBuscaCidade;
    private ControllerCadCidade controllerCadCidade;
    List<Cidade> listaCidade = new ArrayList<Cidade>();
    DefaultTableModel tabela; 
    public ControllerTelaBuscaCidade(TelaBuscaCidade telaBuscaCidade, ControllerCadCidade controller) {
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
        this.telaBuscaCidade = telaBuscaCidade;
        this.controllerCadCidade = controller;
        this.tabela = (DefaultTableModel) this.telaBuscaCidade.getjTableDados().getModel();
        telaBuscaCidade.getjButtonCarregar().addActionListener(this);
        telaBuscaCidade.getjButtonSair().addActionListener(this);
        telaBuscaCidade.getjTFFitrar().getDocument().addDocumentListener(listener);
        
        listaCidade = CidadeService.carregar();
    }
    
    public void carregar(){
        Controller.utilities.Utilities.limpaTabela(tabela);
            if(telaBuscaCidade.getjTFFitrar().getText().length() == 0){
            if(tabela.getDataVector().size() == 0){
                for (Cidade cidadeAtual : listaCidade) {
                tabela.addRow(new Object[] {cidadeAtual.getId(), cidadeAtual.getUf(),cidadeAtual.getDescricao()});
            }
            }
            }else{
                Cidade cidade = new Cidade();
                
                        List<Cidade> bairros = new ArrayList<>();
                                bairros = CidadeService.carregarList(telaBuscaCidade.getjTFFitrar().getText(), telaBuscaCidade.getBuscaChave().getSelectedItem().toString());
                                for (Cidade bairroAtual : bairros) {
                                    tabela.addRow(new Object[] {bairroAtual.getId(), bairroAtual.getUf() ,bairroAtual.getDescricao()});
                 }    
                }
               }
            
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.telaBuscaCidade.getjButtonCarregar()){
            
            int aux = this.telaBuscaCidade.getjTableDados().getSelectedRow();
            this.controllerCadCidade.telaCadastroCidade.getDescricaoTexto().setText(listaCidade.get(aux).getDescricao());
            this.controllerCadCidade.telaCadastroCidade.getIdTexto().setText(Integer.toString(listaCidade.get(aux).getId()));
            this.controllerCadCidade.telaCadastroCidade.getjTextField1().setText(listaCidade.get(aux).getUf());
            
            this.telaBuscaCidade.dispose();
        }
    if(e.getSource() == this.telaBuscaCidade.getjButtonSair()){
        while(tabela.getDataVector().size() != 0){
            tabela.removeRow(0);
            this.controllerCadCidade.telaCadastroCidade.getIdTexto().setText(Integer.toString(DAO.ClasseDados.listaCidade.size() + 1));
        }
    }
    }
    
}
