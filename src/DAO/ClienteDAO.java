/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.bo.Bairro;
import Model.bo.Cidade;
import Model.bo.Cliente;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizf
 */
public class ClienteDAO  implements InterfaceDAO <Cliente>{

    @Override
    public void create(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> retrieve() {
    /*
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT endereco.id, endereco.cep, "
                +"endereco.logradouro, endereco.cidade_id, "
                +"endereco.bairro_id, endereco.status, "
                +"bairro.descricao, cidade.descricao, "
                +"cidade.uf "
                +"from Endereco "
                +"LEFT OUTER JOIN BAIRRO ON BAIRRO.id = endereco.bairro_id "
                +"LEFT OUTER JOIN CIDADE ON CIDADE.id = endereco.cidade_id ";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Cliente> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradoura(rst.getString("logradouro"));
                endereco.setStatus( ""+rst.getString("status"));
                listaBairro.add(endereco);
                
                Bairro bairro = new Bairro();
                bairro.setId(Integer.parseInt(rst.getString("bairro_id")));
                bairro.setDescricao(rst.getString("bairro.descricao"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setId(Integer.parseInt(rst.getString("cidade_id")));
                cidade.setDescricao(rst.getString("cidade.descricao"));
                endereco.setCidade(cidade);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }   */
    List<Cliente> a = new ArrayList<>();
    return a;
    }

    @Override
    public Cliente retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public List<Cliente> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT cliente.cpf, cliente.rg, "
                +"cliente.matricula, "
                +"cliente.nome, cliente.fone1, "
                +"cliente.fone2, cliente.email, cliente.status, "
                +"cliente.complementoendereco, cliente.endereco_id "
                +"from cliente "
                +"LEFT OUTER JOIN ENDERECO ON ENDERECO.id = cliente.endereco_id "
                +"where CLIENTE." + aux + " like ?";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Cliente> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cliente cliente = new Cliente();
                
                cliente.setComplementoEmdereco(rst.getString("complementoendereco"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setEmail(rst.getString("email"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));   
                cliente.setRg(rst.getString("rg"));
                cliente.setStatus(rst.getString("status"));
                
                Endereco endereco = new Endereco();
                endereco.setId(Integer.parseInt(rst.getString("endereco_id")));
                /*
                Bairro bairro = new Bairro();
                bairro.setId(Integer.parseInt(rst.getString("bairro_id")));
                bairro.setDescricao(rst.getString("bairro.descricao"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setId(Integer.parseInt(rst.getString("cidade_id")));
                cidade.setDescricao(rst.getString("cidade.descricao"));
                cidade.setUf(rst.getString("cidade.uf"));
                endereco.setCidade(cidade);*/
                listaBairro.add(cliente);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }
    
}
