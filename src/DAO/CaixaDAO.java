/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.bo.Bairro;
import Model.bo.Caixa;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaixaDAO implements InterfaceDAO <Caixa>{

    @Override
    public void create(Caixa objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblcaixa (dataHoraAbertura,dataHoraFechamento,valorAbertura,valorFechamento,observacao,tblfuncionario_id) VALUES(?,?,?,?,?,?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, ""+objeto.getDataHoraAbertura());
            pstm.setString(2, ""+objeto.getDataHoraFechamento());
            pstm.setFloat(3, objeto.getValorAbertura());
            pstm.setFloat(4, objeto.getValorFechamento());
            pstm.setString(5, ""+objeto.getObservacao());
            pstm.setInt(6, objeto.getFuncionario().getId());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Caixa> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT * FROM tblcaixa";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Caixa> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Caixa bairro = new Caixa();
                bairro.setId(rst.getInt("id"));

                listaBairro.add(bairro);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }

    @Override
    public Caixa retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Caixa retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Caixa objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tblcaixa"
                           + " SET datahorafechamento = ?,"
                           + "valorFechamento = ?,"
                           +"observacao = ?"
                           + " WHERE tblcaixa.id = ?" ;  
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, ""+objeto.getDataHoraFechamento());
            pstm.setFloat(2, objeto.getValorFechamento());
            pstm.setString(3, objeto.getObservacao());
            pstm.setInt(4, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Caixa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
