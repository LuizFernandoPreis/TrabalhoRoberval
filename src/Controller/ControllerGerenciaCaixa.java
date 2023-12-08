/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.utilities.Utilities;
import Model.bo.Caixa;
import Model.bo.funcionario;
import Service.CaixaService;
import Service.FuncionarioService;
import View.GerenciamentoCaixa;
import View.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author luizf
 */
public class ControllerGerenciaCaixa extends Controllers implements ActionListener {
    private GerenciamentoCaixa tela;
    private Menu global;
    private List<Caixa> listaCaixa;
    private List<funcionario> listaFuncionario;
      ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
      ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(1);
    private int on = 1;

    public int getOn() {
        return on;
    }

    public void setOn(int on) {
        this.on = on;
    }
    public ControllerGerenciaCaixa(GerenciamentoCaixa tela, Menu global) {
        this.tela = tela;
        this.global = global;
        listaCaixa = CaixaService.carregar();
        listaFuncionario = FuncionarioService.carregar();
        tela.getAbrirCaixa().addActionListener(this);
        for(funcionario f : listaFuncionario)
        {
            tela.getUsuarioBox().addItem(f.getNome());
        }
        
        
      
        
         Runnable getData = () -> {
            LocalDateTime datas = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            datas.format(formato);
           this.tela.getHoraAbertura().setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());  
           this.tela.getDataAbertura().setText(""+datas.getDayOfMonth()+"/"+datas.getMonthValue()+"/"+datas.getYear());
           
    };
         Runnable getData1 = () -> {
            LocalDateTime datas = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            datas.format(formato);
           this.tela.getHoraFechamento().setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());  
           this.tela.getDataFechamento().setText(""+datas.getDayOfMonth()+"/"+datas.getMonthValue()+"/"+datas.getYear());
           
    };
        scheduler.scheduleAtFixedRate(getData, 0, 1, TimeUnit.SECONDS);
        scheduler1.scheduleAtFixedRate(getData1, 0, 1, TimeUnit.SECONDS);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tela.getAbrirCaixa())
        {
         scheduler.shutdown();
        }
        if(e.getSource() == tela.getFecharCaixa())
        {
            scheduler1.shutdown();
        }
    }
    
    }
