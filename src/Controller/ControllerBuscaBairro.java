
package Controller;

import Model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import service.BairroService;
import view.TelaBuscaBairro;

public class ControllerBuscaBairro implements ActionListener{

    public ControllerBuscaBairro(TelaBuscaBairro telaBuscaBairro, ControllerCadBairro controller) {
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
        this.telaBuscaBairro = telaBuscaBairro;
        this.controller = controller;
        tabela =(DefaultTableModel) this.telaBuscaBairro.getjTableDados().getModel();
        telaBuscaBairro.getCarregar().addActionListener(this);
        telaBuscaBairro.getjButtonSair().addActionListener(this);
        telaBuscaBairro.getjTFFitrar().getDocument().addDocumentListener(listener);
       listaBairros = BairroService.carregar();
       for(Bairro bairroAtual : listaBairros){
           
       }
    }
    
    List<Bairro> listaBairros = new ArrayList<Bairro>();
    DefaultTableModel tabela;
    ControllerCadBairro controller;
    TelaBuscaBairro telaBuscaBairro ;
    
    
    public void carregar(){
        
        listaBairros = BairroService.carregar();
        Controller.utilities.Utilities.limpaTabela(tabela);
                    if(telaBuscaBairro.getjTFFitrar().getText().length() == 0){
                        if(tabela.getDataVector().size() == 0){
                    for (Bairro bairroAtual : listaBairros) {
                    tabela.addRow(new Object[] {bairroAtual.getId(), bairroAtual.getDescricao()});
                }
                }
                    }else{
                        Bairro bairro = new Bairro();


                       
                                if(BairroService.carregar(telaBuscaBairro.getjTFFitrar().getText()).getDescricao() != ""){
                                    bairro = BairroService.carregar(telaBuscaBairro.getjTFFitrar().getText());
                                    if(bairro.getId() != 0){
                                        tabela.addRow(new Object[] {bairro.getId(), bairro.getDescricao()});
                                    }else{
                                        List<Bairro> bairros = new ArrayList<>();
                                bairros = BairroService.carregarList(telaBuscaBairro.getjTFFitrar().getText(), telaBuscaBairro.getBuscaChave().getSelectedItem().toString());
                                for (Bairro bairroAtual : bairros) {
                                    tabela.addRow(new Object[] {bairroAtual.getId(), bairroAtual.getDescricao()});
                                }
                                    }

                                }
                        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaBairro.getjButtonSair()){
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaBairro.dispose();
    }
     if(e.getSource() == this.telaBuscaBairro.getjButtonCarregar()){
            int aux = this.telaBuscaBairro.getjTableDados().getSelectedRow();
            int auxx = Integer.parseInt(this.telaBuscaBairro.getjTableDados().getModel().getValueAt(aux, 0).toString())-1;
            this.controller.telaCadastroBairro.getIdTexto().setText(Integer.toString(listaBairros.get(auxx).getId()));
            this.controller.telaCadastroBairro.getDescricaoTexto().setText(listaBairros.get(auxx).getDescricao());
            Controller.utilities.Utilities.limpaTabela(tabela);
            this.telaBuscaBairro.dispose();
    }
    }

}
