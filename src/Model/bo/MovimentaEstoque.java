/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;
    
import java.time.LocalDateTime;


public class MovimentaEstoque {
    private int id;
    private LocalDateTime dataHoraMovimento;
    private char flagTipoMovimento;
    private float qtdeMovimentada;
    private String observadorMovimento;        
    private char status;

    public MovimentaEstoque() {
    }

    public MovimentaEstoque(int id, LocalDateTime dataHoraMovimento, char flagTipoMovimento, float qtdeMovimentada, String observadorMovimento, char status) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.flagTipoMovimento = flagTipoMovimento;
        this.qtdeMovimentada = qtdeMovimentada;
        this.observadorMovimento = observadorMovimento;
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

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
    }

    public float getQtdeMovimentada() {
        return qtdeMovimentada;
    }

    public void setQtdeMovimentada(float qtdeMovimentada) {
        this.qtdeMovimentada = qtdeMovimentada;
    }

    public String getObservadorMovimento() {
        return observadorMovimento;
    }

    public void setObservadorMovimento(String observadorMovimento) {
        this.observadorMovimento = observadorMovimento;
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
                this.flagTipoMovimento + ", " + 
                this.qtdeMovimentada + ", " + 
                this.observadorMovimento +", " +
                this.status;
    }
    
    
}
