
package Service;

import DAO.CidadeDAO;
import Model.bo.Cidade;
import java.util.List;

public class CidadeService {
    public static void adicionar (Cidade objeto){
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(objeto);
       
    }
   
    public static List<Cidade> carregar(){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve();
    }
   
     public static Cidade carregar(int parPK){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(parPK);
    }
   
     public static Cidade carregar(String parString){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(parString);
    }
     
    public static Cidade carregar(String parString, String aux){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(parString, aux);
    }
   
    public static List<Cidade> carregarList(String parString, String aux){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieveList(parString, aux);
    }
     
    
     public static void atualizar(Cidade objeto){
         CidadeDAO cidadeDAO = new CidadeDAO();
         cidadeDAO.update(objeto);
     }
   
      public static void remover(Cidade objeto){
         CidadeDAO cidadeDAO = new CidadeDAO();
         cidadeDAO.delete(objeto);
     }
}