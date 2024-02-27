/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemVendaDAO implements InterfaceDAO <ItemVenda>{

    @Override
    public void create(ItemVenda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblitemvenda (qtdProduto,valorUnitario,tblVenda_id,tblproduto_id, tblcarteirinha_id) VALUES(?,?,?,?,?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getQtdeProduto());
            pstm.setFloat(2, objeto.getProduto().getValor());
            pstm.setInt(3, objeto.getVenda().getId());
            pstm.setInt(5, objeto.getCarteirinha().getId());
            pstm.setInt(4, objeto.getProduto().getId());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }   
    }

    @Override
    public List<ItemVenda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemVenda retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemVenda retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
