/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.VendaDAO;
import Model.bo.Venda;
import java.util.List;

/**
 *
 * @author luizf
 */
public class VendaService {
    public static void adicionar (Venda objeto){
       VendaDAO bairroDAO = new VendaDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Venda> carregar(){
       VendaDAO bairroDAO = new VendaDAO();
        return bairroDAO.retrieve();
    }
   
     public static Venda carregar(int parPK){
       VendaDAO bairroDAO = new VendaDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Venda carregar(String parString){
        VendaDAO bairroDAO = new VendaDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Venda> carregarList(String parString, String aux){
        VendaDAO bairroDAO = new VendaDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Venda objeto){
         VendaDAO bairroDAO = new VendaDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Venda objeto){
         VendaDAO bairroDAO = new VendaDAO();
         bairroDAO.delete(objeto);
     }
}
