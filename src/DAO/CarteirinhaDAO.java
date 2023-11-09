/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.bo.Bairro;
import Model.bo.Carteirinha;
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
public class CarteirinhaDAO implements InterfaceDAO<Carteirinha>{

    public List<Carteirinha> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT * "
                +"from tblcarteirinha "
                +"LEFT OUTER JOIN tblCliente ON tblcliente.id = tblcarteirinha.tblcliente_id "
                +"where tblcarteirinha." + aux + " like ?";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Carteirinha> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
               Carteirinha ct = new Carteirinha();
               ct.setId(rst.getInt("id"));
               ct.setCodigoBarra(rst.getString("codigoBarra"));
               ct.setDataGeração(rst.getString("dataGeracao"));
               ct.setDataCancelamento(rst.getString("dataCancelamento"));
               
               Cliente cl = new Cliente();
               cl.setId(rst.getInt("tblcliente_id"));
               cl.setNome(rst.getString("nome"));
               cl.setCpf(rst.getString("cpf"));
               ct.setCliente(cl);
               listaBairro.add(ct);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }

    
    @Override
    public void create(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT tblcarteirinha(codigoBarra,dataGeracao,dataCancelamento,tblcliente_id) VALUES(?,?,?,?)";
             
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
  
            pstm.setString(1,objeto.getCodigoBarra());
            pstm.setString(2, objeto.getDataGeração());
            pstm.setString(3, objeto.getDataCancelamento());
            pstm.setInt(4, objeto.getCliente().getId());
            
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Carteirinha> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carteirinha retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carteirinha retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
