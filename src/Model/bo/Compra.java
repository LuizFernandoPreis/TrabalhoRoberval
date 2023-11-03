/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;

import java.time.LocalDateTime;


public class Compra {
    private int id;
    private int numeroNf;
    private float valorDesconto;
    private LocalDateTime dataHoraVenda;
    private char flagTipoDesconto;
    private char status;
    private String observacao;
    
    
        
    public Compra() {
    }

    public Compra(int id, int numeroNf, float valorDesconto, LocalDateTime dataHoraVenda, char flagTipoDesconto, char status, String observacao, ItemCompra itemCompra) {
        this.id = id;
        this.numeroNf = numeroNf;
        this.valorDesconto = valorDesconto;
        this.dataHoraVenda = dataHoraVenda;
        this.flagTipoDesconto = flagTipoDesconto;
        this.status = status;
        this.observacao = observacao;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(int numeroNf) {
        this.numeroNf = numeroNf;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public LocalDateTime getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public char getFlagTipoDesconto() {
        return flagTipoDesconto;
    }

    public void setFlagTipoDesconto(char flagTipoDesconto) {
        this.flagTipoDesconto = flagTipoDesconto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


 

    @Override
    public String toString() {
        return this.id + ", " +
                this.numeroNf + ", " +
                this.dataHoraVenda + ", " + 
                this.valorDesconto + ", " + 
                this.flagTipoDesconto + ", " + 
                this.status + ", " +
                this.observacao ;
    }
    
    
}
