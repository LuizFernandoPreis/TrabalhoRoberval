
package DAO;

import Model.bo.Cidade;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CidadeDAO implements InterfaceDAO <Cidade> {

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cidade (descricao,uf) VALUES(?,?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cidade> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade.id, cidade.descricao, cidade.uf FROM cidade";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Cidade> listaCidade = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                listaCidade.add(cidade);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCidade;
        }
       
    }

    @Override
    public Cidade retrieve(int parPK) {
        
     Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade.id, cidade.descricao, cidade.uf FROM cidade where cidade.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Cidade listaBairro = new Cidade();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                listaBairro = cidade;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }

    @Override
    public Cidade retrieve(String parString) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar ="SELECT cidade.id, cidade.descricao, cidade.uf FROM cidade where cidade.descricao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Cidade listaBairro = new Cidade();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                listaBairro = cidade;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }
    
    

    @Override
    public void update(Cidade objeto) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE cidade"
                           + " SET cidade.descricao = ?,"
                           + " cidade.uf = ? "
                           + " WHERE cidade.id = ?" ;  
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(3, objeto.getId());
            pstm.setString(2, objeto.getUf());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Cidade objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Cidade> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
            String param = "SELECT cidade.id, cidade.descricao, cidade.uf FROM cidade where cidade." + aux + " like ?";
        String sql = param;
        String sqlExecutar = sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Cidade> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                listaBairro.add(cidade);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }

    
    public Cidade retrieve(String parString, String aux) {
        String param = "SELECT cidade.id, cidade.descricao, cidade.uf FROM cidade where cidade." + aux + " = ?";
        String sql = param;
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Cidade listaBairro = new Cidade();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                listaBairro = cidade;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }
   
}
    



