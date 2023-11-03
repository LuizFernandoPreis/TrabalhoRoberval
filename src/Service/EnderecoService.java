
package Service;

import DAO.EnderecoDAO;
import Model.bo.Endereco;
import java.util.List;


public class EnderecoService {
    public static void adicionar (Endereco objeto){
        EnderecoDAO bairroDAO = new EnderecoDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Endereco> carregar(){
        EnderecoDAO bairroDAO = new EnderecoDAO();
        return bairroDAO.retrieve();
    }
   
     public static Endereco carregar(int parPK){
        EnderecoDAO bairroDAO = new EnderecoDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Endereco carregar(String parString){
        EnderecoDAO bairroDAO = new EnderecoDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Endereco> carregarList(String parString, String aux){
        EnderecoDAO bairroDAO = new EnderecoDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Endereco objeto){
         EnderecoDAO bairroDAO = new EnderecoDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Endereco objeto){
         EnderecoDAO bairroDAO = new EnderecoDAO();
         bairroDAO.delete(objeto);
     }
}
