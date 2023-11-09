/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.FuncionarioDAO;
import Model.bo.funcionario;
import java.util.List;

/**
 *
 * @author luizf
 */
public class FuncionarioService {
    public static void adicionar (funcionario objeto){
        FuncionarioDAO bairroDAO = new FuncionarioDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<funcionario> carregar(){
        FuncionarioDAO bairroDAO = new FuncionarioDAO();
        return bairroDAO.retrieve();
    }
   
     public static funcionario carregar(int parPK){
        FuncionarioDAO bairroDAO = new FuncionarioDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static funcionario carregar(String parString){
        FuncionarioDAO bairroDAO = new FuncionarioDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<funcionario> carregarList(String parString, String aux){
        FuncionarioDAO bairroDAO = new FuncionarioDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(funcionario objeto){
         FuncionarioDAO bairroDAO = new FuncionarioDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(funcionario objeto){
         FuncionarioDAO bairroDAO = new FuncionarioDAO();
         bairroDAO.delete(objeto);
     }
    
}
