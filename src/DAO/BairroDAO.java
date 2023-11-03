package DAO;
import Model.bo.Bairro;
import Model.bo.DAO.ConnectionFactory;
import java.sql.Connection;
import Model.bo.DAO.InterfaceDAO;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
public class BairroDAO implements InterfaceDAO <Bairro> {

    @Override
    public void create(Bairro objeto) {
       
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO bairro (descricao) VALUES(?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Bairro> retrieve() {
       
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT bairro.id, bairro.descricao FROM bairro";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Bairro> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));

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
    public Bairro retrieve(int parPK) {
     Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT bairro.id, bairro.descricao FROM bairro where bairro.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Bairro listaBairro = new Bairro();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));
                listaBairro = bairro;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }
    public Bairro retrieve(String parString, String aux) {
        String param = "SELECT bairro.id, bairro.descricao, bairro.uf FROM cidade where bairro." + aux + " = ?";
        String sql = param;
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Bairro listaBairro = new Bairro();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Bairro cidade = new Bairro();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
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
    public Bairro retrieve(String parString) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar ="SELECT bairro.id, bairro.descricao FROM bairro where bairro.descricao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        Bairro listaBairro = new Bairro();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));
                System.out.println(bairro.getDescricao());
                listaBairro = bairro;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE bairro"
                           + " SET bairro.descricao = ?"
                           + " WHERE bairro.id = ?" ;  
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }
    @Override
    public void delete(Bairro objeto) {
 

    }
    public List<Bairro> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT bairro.id, bairro.descricao FROM bairro where bairro." + aux + " like ?";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Bairro> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));
                listaBairro.add(bairro);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }
   
}
 