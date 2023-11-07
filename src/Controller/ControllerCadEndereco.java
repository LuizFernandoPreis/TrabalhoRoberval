
package Controller;


import Model.bo.Bairro;
import Model.bo.Cidade;
import Model.bo.Endereco;
import Service.CidadeService;
import Service.EnderecoService;
import View.TelaCadastroBairro;
import View.TelaCadastroCidade;
import View.TelaCadastroEndereco;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import service.BairroService;

public class ControllerCadEndereco implements ActionListener{
    TelaCadastroEndereco telaCadastroEndereco;
    view.TelaBuscaEndereco telaBusca;
    ControllerBuscaEndereco controller;
    List <Endereco> listaEndereco = new ArrayList<Endereco>();
    List<Cidade> cidades = new ArrayList();
    List<Bairro> bairros = new ArrayList();
    public ControllerCadEndereco(TelaCadastroEndereco telaCadastroEndereco) {
        
                 this.telaCadastroEndereco = telaCadastroEndereco;
                bairros = BairroService.carregar();
                cidades = CidadeService.carregar();
        listaEndereco = EnderecoService.carregar();
        
        
             for(int i = 0; i < bairros.size(); i++){
                 this.telaCadastroEndereco.getBairroBox().addItem(bairros.get(i).getDescricao());
        };
         for(int i = 0; i < cidades.size(); i++){
                 this.telaCadastroEndereco.getCidadeBox().addItem(cidades.get(i).getDescricao());
        };
       
       
        
        this.telaBusca = new view.TelaBuscaEndereco(null,true);
        this.controller = new ControllerBuscaEndereco(telaBusca,this);
       
        this.telaCadastroEndereco.getCancelar().addActionListener(this);
        this.telaCadastroEndereco.getBuscar().addActionListener(this);
        this.telaCadastroEndereco.getNovo().addActionListener(this);
        this.telaCadastroEndereco.getGravar().addActionListener(this);
        this.telaCadastroEndereco.getSair().addActionListener(this);
        Controller.utilities.Utilities.ativa(true, this.telaCadastroEndereco.getBody());
        this.telaCadastroEndereco.getIdTexto().setText(Integer.toString(listaEndereco.size() + 1));
        this.telaCadastroEndereco.getIdTexto().setEnabled(false);
        this.telaCadastroEndereco.getBairroBox().addActionListener(this);
        this.telaCadastroEndereco.getCidadeBox().addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroEndereco.getCancelar()){
            Controller.utilities.Utilities.ativa(true, this.telaCadastroEndereco.getBody());
            Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroEndereco.getBody());
        } else if(e.getSource() == this.telaCadastroEndereco.getNovo()){
            Controller.utilities.Utilities.ativa(false, this.telaCadastroEndereco.getBody());
            
            
        }else if(e.getSource() == this.telaCadastroEndereco.getGravar()){
            
            String on = "";
            if(this.telaCadastroEndereco.getStatus().isSelected() == true){
                on = "a";
            }else if(this.telaCadastroEndereco.getStatus().isSelected() == false){
                on = "";
            }
            
            Bairro bairro = new Bairro();
            bairro.setDescricao(this.telaCadastroEndereco.getBairroBox().getSelectedItem().toString());
            bairro.setId(this.telaCadastroEndereco.getBairroBox().getSelectedIndex()+1);
            Cidade cidade = new Cidade();
            cidade.setDescricao(this.telaCadastroEndereco.getCidadeBox().getSelectedItem().toString());
            cidade.setId(this.telaCadastroEndereco.getCidadeBox().getSelectedIndex()+1);
            cidade.setUf(this.telaCadastroEndereco.getUfText().getText());
            
            listaEndereco = EnderecoService.carregar();
            
            if(Integer.parseInt(this.telaCadastroEndereco.getIdTexto().getText()) > listaEndereco.size()){
                Endereco endereco = new Endereco(listaEndereco.size() + 1,this.telaCadastroEndereco.getCepTexto().getText(), this.telaCadastroEndereco.getLogradouroTexto().getText(), on, bairro, cidade);
                EnderecoService.adicionar(endereco);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroEndereco.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroEndereco.getBody());
                this.telaCadastroEndereco.getIdTexto().setText( Integer.toString(listaEndereco.size() + 1));
            }else if(listaEndereco.contains(listaEndereco.get(Integer.parseInt(this.telaCadastroEndereco.getIdTexto().getText())-1))){
                
                Endereco endereco = listaEndereco.get(Integer.parseInt(this.telaCadastroEndereco.getIdTexto().getText()) - 1);
                endereco.setCep(this.telaCadastroEndereco.getCepTexto().getText());
                endereco.setLogradoura(this.telaCadastroEndereco.getLogradouroTexto().getText());
                endereco.setStatus(on);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                EnderecoService.atualizar(endereco);
                Controller.utilities.Utilities.ativa(true, this.telaCadastroEndereco.getBody());
                Controller.utilities.Utilities.limpaComponentes(true, this.telaCadastroEndereco.getBody());
                
                this.telaCadastroEndereco.getIdTexto().setText( Integer.toString(listaEndereco.size() + 1));
            }
            
            
            
            
            
            
            
            
            
            
        }else if(e.getSource() == this.telaCadastroEndereco.getBuscar()){
            telaBusca.setVisible(true);
        }else if(e.getSource() == this.telaCadastroEndereco.getCidadeBox()){
            this.telaCadastroEndereco.getUfText().setText(cidades.get( this.telaCadastroEndereco.getCidadeBox().getSelectedIndex()).getUf());
           
    }}}
