
package Service;

import DAO.FornecedorDAO;
import Model.bo.Fornecedor;
import java.util.List;

/**
 *
 * @author luizf
 */
public class FornecedorService {
     public static void adicionar (Fornecedor objeto){
        FornecedorDAO bairroDAO = new FornecedorDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Fornecedor> carregar(){
        FornecedorDAO bairroDAO = new FornecedorDAO();
        return bairroDAO.retrieve();
    }
   
     public static Fornecedor carregar(int parPK){
        FornecedorDAO bairroDAO = new FornecedorDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Fornecedor carregar(String parString){
        FornecedorDAO bairroDAO = new FornecedorDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Fornecedor> carregarList(String parString, String aux){
        FornecedorDAO bairroDAO = new FornecedorDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Fornecedor objeto){
         FornecedorDAO bairroDAO = new FornecedorDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Fornecedor objeto){
         FornecedorDAO bairroDAO = new FornecedorDAO();
         bairroDAO.delete(objeto);
     }
}
