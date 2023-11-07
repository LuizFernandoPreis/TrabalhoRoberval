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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luizf
 */
public class ClienteDAO  implements InterfaceDAO <Cliente>{

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT tblcliente(cpf,rg,matricula,nome,fone1,fone2,email,status,complementoendereco,tblendereco_id,datanascimento) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
             
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,objeto.getCpf());
            pstm.setString(2, objeto.getRg());
            pstm.setString(3, objeto.getMatricula());
            pstm.setString(4, objeto.getNome());
            pstm.setString(5, objeto.getFone1());
            pstm.setString(6, objeto.getFone2());
            pstm.setString(7, objeto.getEmail());
            pstm.setString(8, objeto.getStatus());
            pstm.setString(9, objeto.getComplementoEmdereco());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setString(11, objeto.getDataNascimento());
            
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cliente> retrieve() {
        
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT * "
                +"from tblcliente ";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Cliente> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setComplementoEmdereco(rst.getString("complementoendereco"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setEmail(rst.getString("email"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));   
                cliente.setRg(rst.getString("rg"));
                cliente.setStatus(rst.getString("status"));
                cliente.setDataNascimento(rst.getString("datanascimento"));
                
                Endereco endereco = new Endereco();
                endereco.setId(Integer.parseInt(rst.getString("tblendereco_id")));
                
                cliente.setEndereco(endereco);
                listaBairro.add(cliente);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
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
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tblcliente"
                            + " SET nome = ?,"
                            + " fone1 = ?,"
                            + " fone2 = ?,"
                            + " email = ?,"
                            + " complementoendereco = ?,"
                            + " cpf = ?,"
                            + " rg = ?,"
                            + " matricula = ?,"
                            + " dataNascimento = ?,"
                            + " tblendereco_id = ?,"
                            + " status = ?"
                            + " WHERE tblcliente.id = ?" ;  
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getComplementoEmdereco());
            pstm.setString(6, objeto.getCpf());
            pstm.setString(7, objeto.getRg());
            pstm.setString(8, objeto.getMatricula());
            pstm.setString(9, objeto.getDataNascimento());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setString(11, objeto.getStatus());
            pstm.setInt(12, objeto.getId());
            
            pstm.execute(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public List<Cliente> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT * "
                +"from tblcliente "
                +"LEFT OUTER JOIN tblENDERECO ON tblENDERECO.id = tblcliente.tblendereco_id "
                +"LEFT OUTER JOIN tblBAIRRO ON tblBAIRRO.id = tblendereco.tblbairro_id "
                +"LEFT OUTER JOIN tblCIDADE ON tblCIDADE.id = tblendereco.tblcidade_id "
                +"where tblCLIENTE." + aux + " like ?";
                
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
                cliente.setDataNascimento(rst.getString("datanascimento"));
                
                Endereco endereco = new Endereco();
                endereco.setId(Integer.parseInt(rst.getString("tblendereco_id")));
                endereco.setCep(rst.getString("cep"));
                
                Bairro bairro = new Bairro();
                bairro.setId(Integer.parseInt(rst.getString("tblbairro_id")));
                bairro.setDescricao(rst.getString("tblbairro.descricao"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setId(Integer.parseInt(rst.getString("tblcidade_id")));
                cidade.setDescricao(rst.getString("tblcidade.descricao"));
                cidade.setUf(rst.getString("tblcidade.uf"));
                endereco.setCidade(cidade);
                cliente.setEndereco(endereco);
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
