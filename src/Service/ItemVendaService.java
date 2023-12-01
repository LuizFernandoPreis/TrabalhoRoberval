/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.BairroDAO;
import DAO.ItemVendaDAO;
import Model.bo.Bairro;
import Model.bo.ItemVenda;
import java.util.List;

/**
 *
 * @author luizf
 */
public class ItemVendaService {
      public static void adicionar (ItemVenda objeto){
        ItemVendaDAO bairroDAO = new ItemVendaDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<ItemVenda> carregar(){
        ItemVendaDAO bairroDAO = new ItemVendaDAO();
        return bairroDAO.retrieve();
    }
   
     public static ItemVenda carregar(int parPK){
        ItemVendaDAO bairroDAO = new ItemVendaDAO();
        return bairroDAO.retrieve(parPK);
    }
   
     public static ItemVenda carregar(String parString){
        ItemVendaDAO bairroDAO = new ItemVendaDAO();
        return bairroDAO.retrieve(parString);
    }
     
     public static void atualizar(ItemVenda objeto){
         ItemVendaDAO bairroDAO = new ItemVendaDAO();
         bairroDAO.update(objeto);
     }
   
      public static void remover(ItemVenda objeto){
         ItemVendaDAO bairroDAO = new ItemVendaDAO();
         bairroDAO.delete(objeto);
     }
}
