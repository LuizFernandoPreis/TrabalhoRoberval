/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.utilities;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Utilities {
    public static void ativa(boolean ativa, JPanel painel) {
        Component[] componentes  = painel.getComponents();
        for (Component componente : componentes) {
            if(componente instanceof JButton){
                if(((JButton) componente).getActionCommand() == "0"){
                    componente.setEnabled(ativa);
                }else{
                    componente.setEnabled(!ativa);
                }
      
            }
            if(componente instanceof JTextField){
                    if(componente.getName() != "id"){
                        componente.setEnabled(!ativa);
                    }
                }
        }
    }
    public static void limpaComponentes(boolean ativa, JPanel painel) {
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {
            if(componente instanceof JTextField){
                if(componente.getName() != "id"){
                    ((JTextField) componente).setText("");
                }
            }else if(componente instanceof JFormattedTextField){
                ((JFormattedTextField) componente).setText("");
            }else if(componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedIndex(-1);
            }else if(componente instanceof JTextArea){
                ((JTextArea) componente).setText("");
            }
            
        }
    }
    public static void limpaTabela(DefaultTableModel tabela){
        while(tabela.getDataVector().size() != 0){
            tabela.removeRow(0);
        }
    }
}
