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
public class Fornecedor extends Pessoa{
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String inscricaoEstadual) {
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    public Fornecedor(String cnpj, String inscricaoEstadual, String razaoSocial, int id, String nome, String fone1, String fone2, String email, char status, String complementoEmdereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEmdereco, endereco);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return this.getNome() + ", " +
                this.getEmail() + ", " + 
                this.getFone1() + ", " + 
                this.getFone2() + ", " +
                this.getStatus() + ", " +
                this.getComplementoEmdereco()+ ", " +
                this.getEndereco() + 
                this.cnpj + ", " + 
                this.inscricaoEstadual + ", " +
                this.razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
}
