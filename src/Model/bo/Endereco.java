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
public class Endereco {
    public int id;
    public String cep;
    private String logradoura;
    private String status;
    
    private Bairro bairro;
    private Cidade cidade;

    @Override
    public String toString() {
        try{
        return "Endereco{" + "id=" + id + ", cep=" + cep 
                + ", logradoura=" + logradoura + ", status=" 
                + status + ", bairro=" + bairro + ", cidade=" + cidade + '}'
                + this.bairro.getDescricao() + this.cidade.getDescricao();}catch(Exception e){
                    
                }finally{
            
        };
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradoura() {
        return logradoura;
    }

    public void setLogradoura(String logradoura) {
        this.logradoura = logradoura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Endereco(int id, String cep, String logradoura, String status, Bairro bairro, Cidade cidade) {
        this.id = id;
        this.cep = cep;
        this.logradoura = logradoura;
        this.status = status;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco() {
    }
}
