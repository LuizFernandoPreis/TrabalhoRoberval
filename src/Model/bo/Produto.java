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
public class Produto {
    private int id;
    private String descricao;
    private String codigoBarra;
    private String status;
    private float valor;
    
    public Produto() {
    }

    public Produto(int id, String descricao, String codigoBarra, String status,float valor) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.status = status;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.id + ", " + 
                this.descricao + ", " + 
                this.status + ", " + 
                this.codigoBarra + ", " ;
                
                
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
