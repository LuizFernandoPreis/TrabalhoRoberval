
package DAO;
import Model.bo.Bairro;
import Model.bo.Cidade;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class EnderecoDAO implements InterfaceDAO <Endereco> {

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblEndereco (cep,logradouro, status,tblbairro_id,tblcidade_id) VALUES(?,?,?,"
                + "(SELECT id FROM tblbairro WHERE descricao LIKE ?),"
                + "(SELECT id FROM tblcidade WHERE descricao LIKE ?))";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradoura());
            pstm.setString(4, objeto.getBairro().getDescricao());
            pstm.setString(5, objeto.getCidade().getDescricao());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }    }

    @Override
    public List<Endereco> retrieve() {
        
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT tblendereco.id, tblendereco.cep, "
                +"tblendereco.logradouro, tblendereco.tblcidade_id, "
                +"tblendereco.tblbairro_id, tblendereco.status, "
                +"tblbairro.descricao, tblcidade.descricao, "
                +"tblcidade.uf "
                +"from tblEndereco "
                +"LEFT OUTER JOIN tblBAIRRO ON tblBAIRRO.id = tblendereco.tblbairro_id "
                +"LEFT OUTER JOIN tblCIDADE ON tblCIDADE.id = tblendereco.tblcidade_id ";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Endereco> listaBairro = new ArrayList<>();

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
                bairro.setId(Integer.parseInt(rst.getString("tblbairro_id")));
                bairro.setDescricao(rst.getString("tblbairro.descricao"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setId(Integer.parseInt(rst.getString("tblcidade_id")));
                cidade.setDescricao(rst.getString("tblcidade.descricao"));
                endereco.setCidade(cidade);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }

    @Override
    public Endereco retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Endereco objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tblendereco"
                           + " SET tblendereco.cep = ?,"
                           + " tblendereco.logradouro = ?,"
                           + " tblendereco.tblcidade_id = ?,"
                           + " tblendereco.tblbairro_id = ?,"
                           + " tblendereco.status = ?"
                           + " WHERE tblendereco.id = ?" ;  
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradoura());
            pstm.setInt(3, objeto.getCidade().getId());
            pstm.setInt(4, objeto.getBairro().getId());
            pstm.setString(5, objeto.getStatus());
            pstm.setInt(6, objeto.getId());
            pstm.execute(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Endereco objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Endereco> retrieveList(String parString, String aux) {
 
            Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT tblendereco.id, tblendereco.cep, "
                +"tblendereco.logradouro, tblendereco.tblcidade_id, "
                +"tblendereco.tblbairro_id, tblendereco.status, "
                +"tblbairro.descricao, tblcidade.descricao, "
                +"tblcidade.uf "
                +"from tblEndereco "
                +"LEFT OUTER JOIN tblBAIRRO ON tblBAIRRO.id = tblendereco.tblbairro_id "
                +"LEFT OUTER JOIN tblCIDADE ON tblCIDADE.id = tblendereco.tblcidade_id "
                +"where tblENDERECO." + aux + " like ?";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Endereco> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradoura(rst.getString("logradouro"));
                endereco.setStatus( ""+rst.getString("status"));
                listaBairro.add(endereco);
                
                Bairro bairro = new Bairro();
                bairro.setId(Integer.parseInt(rst.getString("tblbairro_id")));
                bairro.setDescricao(rst.getString("tblbairro.descricao"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setId(Integer.parseInt(rst.getString("tblcidade_id")));
                cidade.setDescricao(rst.getString("tblcidade.descricao"));
                cidade.setUf(rst.getString("tblcidade.uf"));
                endereco.setCidade(cidade);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }
}
