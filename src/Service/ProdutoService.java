
package Service;

import DAO.ProdutoDAO;
import Model.bo.Produto;
import java.util.List;

public class ProdutoService {
    public static void adicionar (Produto objeto){
        ProdutoDAO cidadeDAO = new ProdutoDAO();
        cidadeDAO.create(objeto);
       
    }
   
    public static List<Produto> carregarList(String parPk, String aux){
        ProdutoDAO cidadeDAO = new ProdutoDAO();
        return cidadeDAO.retrieveList(parPk, aux);
    }
    
   public static List<Produto> carregar(){
        ProdutoDAO cidadeDAO = new ProdutoDAO();
        return cidadeDAO.retrieve();
    }
   
     public static Produto carregar(int parPK){
        ProdutoDAO cidadeDAO = new ProdutoDAO();
        return cidadeDAO.retrieve(parPK);
    }
   
     public static Produto carregar(String parString){
        ProdutoDAO cidadeDAO = new ProdutoDAO();
        return cidadeDAO.retrieve(parString);
    }
   
     
     public static void atualizar(Produto objeto){
         ProdutoDAO cidadeDAO = new ProdutoDAO();
         cidadeDAO.update(objeto);
     }
   
      public static void remover(Produto objeto){
         ProdutoDAO cidadeDAO = new ProdutoDAO();
         cidadeDAO.delete(objeto);
     }
}
