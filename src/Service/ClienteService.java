
package Service;

import DAO.ClienteDAO;
import Model.bo.Cliente;
import java.util.List;

/**
 *
 * @author luizf
 */
public class ClienteService {
        public static void adicionar (Cliente objeto){
        ClienteDAO bairroDAO = new ClienteDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Cliente> carregar(){
        ClienteDAO bairroDAO = new ClienteDAO();
        return bairroDAO.retrieve();
    }
   
     public static Cliente carregar(int parPK){
        ClienteDAO bairroDAO = new ClienteDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Cliente carregar(String parString){
        ClienteDAO bairroDAO = new ClienteDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Cliente> carregarList(String parString, String aux){
        ClienteDAO bairroDAO = new ClienteDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Cliente objeto){
         ClienteDAO bairroDAO = new ClienteDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Cliente objeto){
         ClienteDAO bairroDAO = new ClienteDAO();
         bairroDAO.delete(objeto);
     }
}
