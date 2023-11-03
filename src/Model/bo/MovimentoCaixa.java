/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;

import java.time.LocalDateTime;

/**
 *
 * @author aluno
 */
public class MovimentoCaixa {
    private int id;
    private LocalDateTime dataHoraMovimento;
    private float valorMovimento;
    private char flagTipoMovimento;
    private String observacao;
    private char status;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int id, LocalDateTime dataHoraMovimento, float valorMovimento, char flagTipoMovimento, String observacao, char status) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.valorMovimento = valorMovimento;
        this.flagTipoMovimento = flagTipoMovimento;
        this.observacao = observacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public float getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(float valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
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

    @Override
    public String toString() {
        return this.id + ", " +
                this.dataHoraMovimento + ", " +
                this.valorMovimento + ", " +
                this.valorMovimento + ", " + 
                this.observacao + ", " + 
                this.status;
    }
    
    
    
    
}
