/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.utilities;

import Controller.Controllers;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Utilities {
    
    public static LocalDateTime StringToData(String dataString){
        // String a ser convertida para DateTime
        String stringData = dataString;

        // Formato da string
        SimpleDateFormat formatoString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = null;
        try {
            // Convertendo a string para Date
            Date data = formatoString.parse(stringData);

            // Convertendo Date para LocalDateTime (Java 8+)
           localDateTime = data.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return localDateTime;
    }
    
    public static void setDatas(JTextField data, JTextField hora, Controllers c){
         ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        Runnable getData = () -> {
            LocalDateTime datas = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            datas.format(formato);
            hora.setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());  
            data.setText(""+datas.getDayOfMonth()+"/"+datas.getMonthValue()+"/"+datas.getYear());
            if(c.getOn() == 0)
            {
                scheduler.shutdown();
            }
    };
        scheduler.scheduleAtFixedRate(getData, 0, 1, TimeUnit.SECONDS);
    }
    
     public static Component testaCampos( JPanel painel) {
        Component aux = new JButton();
        Component[] componentes  = painel.getComponents();
        for (Component componente : componentes) {
           if(componente instanceof JFormattedTextField){
                    if(((JFormattedTextField) componente).getText().length() == 0){
                        return componente;
                    }
                }
            if(componente instanceof JTextField){
                    if(((JTextField) componente).getText().length() == 0){
                        return componente;
                    }
                }
        }
        return aux;
    }
     
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
