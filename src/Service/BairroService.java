package service;

import DAO.BairroDAO;
import Model.bo.Bairro;
import java.util.List;

public class BairroService {
   
    public static void adicionar (Bairro objeto){
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Bairro> carregar(){
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve();
    }
   
     public static Bairro carregar(int parPK){
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Bairro carregar(String parString){
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Bairro> carregarList(String parString, String aux){
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Bairro objeto){
         BairroDAO bairroDAO = new BairroDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Bairro objeto){
         BairroDAO bairroDAO = new BairroDAO();
         bairroDAO.delete(objeto);
     }
}