/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.bo.Caixa;
import Model.bo.Carteirinha;
import Model.bo.ItemVenda;
import Model.bo.Produto;
import Model.bo.Venda;
import Model.bo.funcionario;
import Service.CaixaService;
import Service.ItemVendaService;
import Service.ProdutoService;
import Service.VendaService;
import View.CadastroVendas;
import View.GerenciamentoCaixa;
import View.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luizf
 */
public class ControllerVenda implements ActionListener{
    private CadastroVendas vendas;
    private LocalDateTime data;
    private List<Venda> listaVendas;
    private List<Produto> listaprodutos;
    private List<Caixa> listaCaixa;
    private boolean qtd = false;
    private LocalDateTime dataHoraAtual;
    private int funcionarioId = 4;
    private Caixa caixaId;
    DefaultTableModel tabela;
    
    public ControllerVenda(CadastroVendas tela) {
        this.vendas = tela;
        this.data = data;
        listaprodutos = ProdutoService.carregar();
        listaCaixa = CaixaService.carregar();
        tabela = (DefaultTableModel) this.vendas.getProdutosTabela().getModel();
        
        
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                caixaPass();
                if(getCaixa()){
                    addProduto();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               if(getCaixa()){
                    addProduto();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               if(getCaixa()){
                    addProduto();
                }
            }
        };
        
        
        this.vendas.getCodigobarraTexto().getDocument().addDocumentListener(listener);
        KeyListener l = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    finalizaCompra();
                }
                if(e.isControlDown())
                {
                    qtd = !qtd;
                }
                if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
                    vendas.dispose();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 18){
                    funcionarioId = Integer.parseInt(JOptionPane.showInputDialog("id do funcionario"));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        };
        this.vendas.getCodigobarraTexto().addKeyListener(l);
    }
        
    
    
    public void caixaPass(){
        if(!isCaixaOpen()){
            Menu menu = new Menu();
            GerenciamentoCaixa tela = new GerenciamentoCaixa();
            ControllerGerenciaCaixa caixa = new ControllerGerenciaCaixa(tela, menu);
            vendas.dispose();
            System.out.println("cu");
            tela.setVisible(true);
        };
    } 
    
    
    
    public boolean isCaixaOpen(){
        for(Caixa caixa : listaCaixa){
            if(caixa.getStatus().length() < 2){
                caixaId = caixa;
                return true;
            };
        }
        return false;
    }
    
    
    public void addProduto(){
        
        int quantidade = 1;
        float valorTotal = 0;
        String codigoBarra = this.vendas.getCodigobarraTexto().getText();
        if(codigoBarra.length() == 13)
        {
                            System.out.println("c");

            if(qtd == true)
            {
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade de Produtos"));
            }
            for(Produto produto : listaprodutos)
            {
                if (produto.getCodigoBarra().equals(codigoBarra))
                {
                      valorTotal = produto.getValor() * quantidade;
                      tabela.addRow(new Object[] {produto.getId(), produto.getCodigoBarra(), produto.getDescricao(), quantidade,produto.getValor(), valorTotal});
                }
            }
        }
        this.vendas.getValorTexto().setText(""+setValor());
    }
    
    public float setValor(){
        float valor = 0 ;
        for(int i = 0; i < tabela.getRowCount();i++){
            valor += Float.parseFloat(tabela.getValueAt(i, 5).toString());
        }
        
        return valor;
    }
    
    
    public void finalizaCompra()
    {
        
        int carteirinhaId = Integer.parseInt(JOptionPane.showInputDialog("Leia a Carteirinha"));
        
        dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        listaVendas = VendaService.carregar();
        
        Venda venda = new Venda();
        funcionario funcionario = new funcionario();
        Carteirinha carteirinha = new Carteirinha();
        
        venda.setDataHoraVenda(""+dataHoraAtual.format(formato));
        venda.setValorDesconto(0);
        venda.setId(listaVendas.size() + 1);
        
        carteirinha.setId(carteirinhaId);
        funcionario.setId(funcionarioId);
        
        venda.setCarteirinha(carteirinha);
        venda.setFuncionario(funcionario);
        
        VendaService.adicionar(venda);
        
        for(int i = 0; i < tabela.getRowCount();i++)
        {
            Produto produto = new Produto();
            ItemVenda itemVenda = new ItemVenda();
            
            produto.setId(Integer.parseInt(tabela.getValueAt(i, 0).toString()));
            produto.setValor(Float.parseFloat(tabela.getValueAt(i, 4).toString()));
            itemVenda.setQtdeProduto(Integer.parseInt(tabela.getValueAt(i, 3).toString()));
            itemVenda.setCarteirinha(carteirinha);
            itemVenda.setVenda(venda);
            itemVenda.setProduto(produto);
            
            ItemVendaService.adicionar(itemVenda);
        }
       
        caixaId.setValorFechamento( caixaId.getValorFechamento() +  Float.parseFloat(vendas.getValorTexto().getText()));
        CaixaService.atualizar(caixaId);
        tabela.setRowCount(0);
        this.vendas.getCodigobarraTexto().setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    public Boolean getCaixa(){
        ArrayList<Caixa> listaCaixa = (ArrayList<Caixa>) CaixaService.carregar();
        for(Caixa caixa: listaCaixa){
            if(caixa.getStatus().length() < 2){
                return true;
            }
        }
        return false;
    }
}
