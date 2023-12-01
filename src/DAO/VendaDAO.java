package DAO;

import Model.bo.Bairro;
import Model.bo.Carteirinha;
import Model.bo.Cidade;
import Model.bo.DAO.ConnectionFactory;
import Model.bo.DAO.InterfaceDAO;
import Model.bo.Endereco;
import Model.bo.Venda;
import Model.bo.funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luizf
 */
public class VendaDAO implements InterfaceDAO<Venda>{

    @Override
    public void create(Venda objeto) {
     Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblvenda (dataHoraVenda,ValorDesconto,observacao,tblfuncionario_id, tblcarteirinha_id) VALUES(?,?,?,?,?)";
       
        PreparedStatement pstm;
        pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDataHoraVenda());
            pstm.setFloat(2, objeto.getValorDesconto());
            pstm.setInt(4, objeto.getFuncionario().getId());
            pstm.setInt(5, objeto.getCarteirinha().getId());
            pstm.setString(3, objeto.getObservacao());
              pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }   
    }

    @Override
    public List<Venda> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String param = "SELECT *"
                +"from tblVenda "
                +"LEFT OUTER JOIN tblfuncionario ON tblfuncionario.id = tblvenda.tblfuncionario_id "
                +"LEFT OUTER JOIN tblcarteirinha ON tblcarteirinha.id = tblvenda.tblcarteirinha_id ";
                
        String sql = param;
        String sqlExecutar =sql;
        PreparedStatement pstm = null;
        ResultSet rst = null ;
        List<Venda> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                Venda venda = new Venda();
                venda.setId(rst.getInt("id"));
                venda.setDataHoraVenda(rst.getString("dataHoraVenda"));
                venda.setValorDesconto(rst.getFloat("valorDesconto"));
                venda.setObservacao(rst.getString("observacao"));
                
                funcionario funcionario = new funcionario();
                funcionario.setId(rst.getInt("tblfuncionario_id"));
                
                Carteirinha carteirinha = new Carteirinha();
                carteirinha.setId(rst.getInt("tblcarteirinha_id"));
              
                venda.setFuncionario(funcionario);
                venda.setCarteirinha(carteirinha);
                listaBairro.add(venda);
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
    }

    @Override
    public Venda retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venda retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Venda> retrieveList(String parString, String aux) {
 
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
        List<Venda> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%"+parString+"%");
            rst = pstm.executeQuery();
           
           
           
            while(rst.next()){
                /*
                Venda endereco = new Venda();
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
            */}
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        

          }
    
}
