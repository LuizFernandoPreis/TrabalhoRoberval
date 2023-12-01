/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;

/**
 *
 * @author aluno
 */
public class ItemVenda {
    private int id;
    private float qtdeProduto;
    private float valorUnitario;
    private char status;
    private Produto produto;
    private Venda venda;
    public ItemVenda() {
    }

    public ItemVenda(int id, float qtdeProduto, float valorUnitario, char status, Produto produto, Venda venda) {
        this.id = id;
        this.qtdeProduto = qtdeProduto;
        this.valorUnitario = valorUnitario;
        this.status = status;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(float qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return this.id + ", " +
                this.valorUnitario + ", "+
                this.qtdeProduto + ", " +
                this.status + ", " + this.produto.toString() + ", " + this.venda.toString();
    }
    
}
