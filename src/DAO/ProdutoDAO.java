/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.bo.Cidade;
import java.sql.SQLException;
import java.sql.Connection;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO implements InterfaceDAO <Produto> {

    @Override
    public void create(Produto objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO produto (descricao, codigoBarra, status) VALUES(?,?,?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Produto> retrieve() {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT produto.id, produto.descricao, produto.codigoBarra, produto.status FROM produto";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Produto> listaProduto = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus("" + rst.getString("status"));
                listaProduto.add(produto);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProduto;
        }
    }

    @Override
    public Produto retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto retrieve(String parString) {
         Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT cantina.produto.id, cantina.produto.descricao, cantina.produto.codigoBarra, cantina.produto.status from produto  where produto.descricao = ?";
        String sql = param;
        String sqlExecutar = sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Produto listaProduto = new Produto();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus("" + rst.getString("status"));
                
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProduto;
        }
    }

    @Override
    public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE produto"
                           + " SET produto.descricao = ?,"
                           + " produto.codigoBarra = ?, "
                           + " produto.status = ?"
                           + " WHERE produto.id = ?" ;  
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(4, objeto.getId());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Produto> retrieveList(String parString, String aux) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT produto.id, produto.descricao, produto.codigoBarra, produto.status from produto where produto."  + aux + " like ?";
        String sql = param;
        String sqlExecutar = sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Produto> listaProduto = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus("" + rst.getString("status"));
                listaProduto.add(produto);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProduto;
        }
    }
    
}
