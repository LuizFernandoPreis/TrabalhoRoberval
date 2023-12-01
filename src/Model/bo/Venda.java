/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;
import java.time.LocalDateTime;

public class Venda {
    private int id;
    private String dataHoraVenda;
    private float valorDesconto = 0.0f;
    private char flagTipoDesconto;
    private String observacao = "";
    private char status;
    private funcionario funcionario;
    private Carteirinha carteirinha;
    private ItemVenda itemVenda;
    
    public Venda() {
    }

    public Venda(int id, String dataHoraVenda, float valorDesconto, char flagTipoDesconto, String observacao, char status, Carteirinha carteirinha, ItemVenda itemVenda, funcionario func) {
        this.id = id;
        this.dataHoraVenda = dataHoraVenda;
        this.valorDesconto = valorDesconto;
        this.flagTipoDesconto = flagTipoDesconto;
        this.observacao = observacao;
        this.status = status;
        this.carteirinha = carteirinha;
        this.funcionario = func;
       this.itemVenda = itemVenda;
    }

    public funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(String dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public char getFlagTipoDesconto() {
        return flagTipoDesconto;
    }

    public void setFlagTipoDesconto(char flagTipoDesconto) {
        this.flagTipoDesconto = flagTipoDesconto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    @Override
    public String toString() {
        return this.dataHoraVenda + ", " + this.flagTipoDesconto + ", " + 
                this.valorDesconto + ", " + this.id + ", " + this.status + ", " +
                this.observacao + ", " + this.carteirinha.toString() + ", " ;
               
    }
    
    
}
