/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;


public class Carteirinha {
    private int id;
    private String codigoBarra;
    private String dataGeração;
    private String dataCancelamento;

    private Cliente cliente;
    
    public Carteirinha() {
    }

    public Carteirinha(int id, String codigoBarra, String dataGeração, String dataCancelamento, Cliente cliente) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.dataGeração = dataGeração;
        this.dataCancelamento = dataCancelamento;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDataGeração() {
        return dataGeração;
    }

    public void setDataGeração(String dataGeração) {
        this.dataGeração = dataGeração;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(String dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    @Override
    public String toString() {
        return this.id + ", " +  
        this.codigoBarra +", " + 
        this.dataCancelamento + ", " + 
        this.dataGeração + ", " +
        this.cliente.toString();
    }
    
}
