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
public class Contas {
    private int id;
    private LocalDateTime dataHoraEmissao;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataQuitacao;
    private float valorEmitido;
    private float valorDesconto;
    private float valorCrescimo;
    private float valorQuitado;
    private String observacao;
    private char flagTipoConta;
    private char status;

    private MovimentoCaixa movimentoCaixa;
    
    public Contas() {
    }

    public Contas(int id, LocalDateTime dataHoraEmissao, LocalDateTime dataVencimento, LocalDateTime dataQuitacao, float valorEmitido, float valorDesconto, float valorCrescimo, float valorQuitado, String observacao, char flagTipoConta, char status, MovimentoCaixa movimentoCaixa) {
        this.id = id;
        this.dataHoraEmissao = dataHoraEmissao;
        this.dataVencimento = dataVencimento;
        this.dataQuitacao = dataQuitacao;
        this.valorEmitido = valorEmitido;
        this.valorDesconto = valorDesconto;
        this.valorCrescimo = valorCrescimo;
        this.valorQuitado = valorQuitado;
        this.observacao = observacao;
        this.flagTipoConta = flagTipoConta;
        this.status = status;
        this.movimentoCaixa = movimentoCaixa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(LocalDateTime dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public float getValorEmitido() {
        return valorEmitido;
    }

    public void setValorEmitido(float valorEmitido) {
        this.valorEmitido = valorEmitido;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorCrescimo() {
        return valorCrescimo;
    }

    public void setValorCrescimo(float valorCrescimo) {
        this.valorCrescimo = valorCrescimo;
    }

    public float getValorQuitado() {
        return valorQuitado;
    }

    public void setValorQuitado(float valorQuitado) {
        this.valorQuitado = valorQuitado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagTipoConta() {
        return flagTipoConta;
    }

    public void setFlagTipoConta(char flagTipoConta) {
        this.flagTipoConta = flagTipoConta;
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
                this.dataHoraEmissao + ", " +
                this.dataVencimento + ", " + 
                this.dataQuitacao + ", " +
                this.valorEmitido + ", " + 
                this.valorDesconto + ", " + 
                this.valorDesconto + ", " +
                this.valorCrescimo + ", " +
                this.valorQuitado + ", " +
                this.observacao + ", " +
                this.flagTipoConta + ", " +
                this.status;
    }
    
    
}
