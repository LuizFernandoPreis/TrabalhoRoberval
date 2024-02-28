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
public class Caixa {
    private int id;
    private LocalDateTime dataHoraAbertura;
    private LocalDateTime dataHoraFechamento;
    private float valorAbertura;
    private float valorFechamento;
    private String observacao;
    private String status;
    private funcionario funcionario;
    private MovimentoCaixa movimentoCaixa;

    public Caixa() {
    }

    public funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(funcionario funcionario) {
        this.funcionario = funcionario;
    }
    

    public Caixa(int id, LocalDateTime dataHoraAbertura, LocalDateTime dataHoraFechamento, float valorAbertura, float valorFechamento, String observacao, String status, MovimentoCaixa movimentoCaixa) {
        this.id = id;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorAbertura = valorAbertura;
        this.valorFechamento = valorFechamento;
        this.observacao = observacao;
        this.status = status;
        this.movimentoCaixa = movimentoCaixa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public LocalDateTime getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(LocalDateTime dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public float getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(float valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public float getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(float valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MovimentoCaixa getMovimentoCaixa() {
        return movimentoCaixa;
    }

    public void setMovimentoCaixa(MovimentoCaixa movimentoCaixa) {
        this.movimentoCaixa = movimentoCaixa;
    }

    @Override
    public String toString() {
        return this.id + ", " +
                this.dataHoraAbertura + ", " +
                this.dataHoraFechamento + ", " +
                this.valorAbertura + ", " +
                this.valorFechamento + ", " +
                this.observacao + ", " + 
                this.status;
    }
    
    
}
