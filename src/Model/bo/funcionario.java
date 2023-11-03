/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bo;


public class funcionario extends Pessoa{
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;

    public funcionario() {
    }

    public funcionario(String cpf, String rg, String usuario, String senha, int id, String nome, String fone1, String fone2, String email, String status, String complementoEmdereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEmdereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getNome() + ", " +
                this.getEmail() + ", " + 
                this.getFone1() + ", " + 
                this.getFone2() + ", " +
                this.getStatus() + ", " +
                this.getComplementoEmdereco()+ ", " +
                this.getEndereco() + ", " +
                this.cpf + ", " +
                this.rg + ", " + 
                this.usuario + ", " + 
                this.senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
