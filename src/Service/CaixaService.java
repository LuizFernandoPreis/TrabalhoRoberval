/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.CaixaDAO;
import Model.bo.Caixa;
import java.util.List;

/**
 *
 * @author luizf
 */
public class CaixaService {
     
    public static void adicionar (Caixa objeto){
        CaixaDAO bairroDAO = new CaixaDAO();
        bairroDAO.create(objeto);
       
    }
   
    public static List<Caixa> carregar(){
        CaixaDAO bairroDAO = new CaixaDAO();
        return bairroDAO.retrieve();
    }
   
}
