/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.CarteirinhaDAO;
import Model.bo.Carteirinha;
import java.util.List;

/**
 *
 * @author luizf
 */
public class CarteirinhaService {
    public static void adicionar (Carteirinha objeto){
        CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Carteirinha> carregar(){
        CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
        return bairroDAO.retrieve();
    }
   
     public static Carteirinha carregar(int parPK){
        CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static Carteirinha carregar(String parString){
        CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
        return bairroDAO.retrieve(parString);
    }
   
     public static List<Carteirinha> carregarList(String parString, String aux){
        CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
        return bairroDAO.retrieveList(parString, aux);
    }
     
     public static void atualizar(Carteirinha objeto){
         CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(Carteirinha objeto){
         CarteirinhaDAO bairroDAO = new CarteirinhaDAO();
         bairroDAO.delete(objeto);
     }
}
