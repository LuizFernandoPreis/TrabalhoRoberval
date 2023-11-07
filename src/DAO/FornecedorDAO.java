/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.bo.Bairro;
import Model.bo.Cidade;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.Endereco;
import Model.bo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FornecedorDAO implements InterfaceDAO <Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT tblfornecedor(nome,fone1,fone2,email,status,complementoendereco,tblendereco_id,razaoSocial,inscricaoestadual,cnpj) VALUES(?,?,?,?,?,?,?,?,?,?)";
             
        PreparedStatement pstm;
        pstm = null;
        try {
            
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getComplementoEmdereco());
            pstm.setInt(7, objeto.getEndereco().getId());
            pstm.setString(8, objeto.getRazaoSocial());
            pstm.setString(9, objeto.getInscricaoEstadual());
            pstm.setString(10, objeto.getCnpj());
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        
        
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT * "
                +"from tblfornecedor "
                +"LEFT OUTER JOIN tblENDERECO ON tblENDERECO.id = tblfornecedor.tblendereco_id "
                +"LEFT OUTER JOIN tblBAIRRO ON tblBAIRRO.id = tblendereco.tblbairro_id "
                +"LEFT OUTER JOIN tblCIDADE ON tblCIDADE.id = tblendereco.tblcidade_id ";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Fornecedor> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Fornecedor cliente = new Fornecedor();
                
                cliente.setId(rst.getInt("id"));
                cliente.setComplementoEmdereco(rst.getString("complementoendereco"));
                cliente.setCnpj(rst.getString("cnpj"));
                cliente.setEmail(rst.getString("email"));
                cliente.setRazaoSocial(rst.getString("razaosocial"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));   
                cliente.setStatus(rst.getString("status"));
                cliente.setInscricaoEstadual(rst.getString("inscricaoestadual"));
                
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

    @Override
    public Fornecedor retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fornecedor retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tblfornecedor"
                            + " SET nome = ?,"
                            + " fone1 = ?,"
                            + " fone2 = ?,"
                            + " email = ?,"
                            + " complementoendereco = ?,"
                            + " cnpj = ?,"
                            + " inscricaoEstadual = ?,"
                            + " razaoSocial = ?,"
                            + " tblendereco_id = ?,"
                            + " status = ?"
                            + " WHERE tblfornecedor.id = ?" ;  
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getComplementoEmdereco());
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getInscricaoEstadual());
            pstm.setString(8, objeto.getRazaoSocial());
            pstm.setInt(9, objeto.getEndereco().getId());
            pstm.setString(10, objeto.getStatus());
            pstm.setInt(11, objeto.getId());
            
            pstm.execute(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public List<Fornecedor> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT * "
                +"from tblfornecedor "
                +"LEFT OUTER JOIN tblENDERECO ON tblENDERECO.id = tblfornecedor.tblendereco_id "
                +"LEFT OUTER JOIN tblBAIRRO ON tblBAIRRO.id = tblendereco.tblbairro_id "
                +"LEFT OUTER JOIN tblCIDADE ON tblCIDADE.id = tblendereco.tblcidade_id "
                +"where tblfornecedor." + aux + " like ?";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Fornecedor> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Fornecedor cliente = new Fornecedor();
                
                cliente.setId(rst.getInt("id"));
                cliente.setComplementoEmdereco(rst.getString("complementoendereco"));
                cliente.setCnpj(rst.getString("cnpj"));
                cliente.setEmail(rst.getString("email"));
                cliente.setRazaoSocial(rst.getString("razaosocial"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));   
                cliente.setStatus(rst.getString("status"));
                cliente.setInscricaoEstadual(rst.getString("inscricaoestadual"));
                
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
