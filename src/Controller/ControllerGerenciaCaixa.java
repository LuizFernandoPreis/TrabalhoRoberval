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
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(1);


    public ControllerGerenciaCaixa(GerenciamentoCaixa tela, Menu global) {
        this.tela = tela;
        this.global = global;
        listaCaixa = CaixaService.carregar();
        listaFuncionario = FuncionarioService.carregar();
        tela.getAbrirCaixa().addActionListener(this);
        tela.getFecharCaixa().addActionListener(this);
        tela.getSaldoFechamento().setText("0");
        for(funcionario f : listaFuncionario)
        {
            tela.getUsuarioBox().addItem(f.getNome());
        }
        
        
      
        
         Runnable getData = () -> {
            LocalDateTime datas = LocalDateTime.now();
            
            datas.format(formato);
           this.tela.getHoraAbertura().setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());  
           this.tela.getDataAbertura().setText(""+datas.getDayOfMonth()+"/"+datas.getMonthValue()+"/"+datas.getYear());
           
    };
         Runnable getData1 = () -> {
            LocalDateTime datas = LocalDateTime.now();
            datas.format(formato);
           this.tela.getHoraFechamento().setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());  
           this.tela.getDataFechamento().setText(""+datas.getDayOfMonth()+"/"+datas.getMonthValue()+"/"+datas.getYear());
           
    };
        scheduler.scheduleAtFixedRate(getData, 0, 1, TimeUnit.SECONDS);
        scheduler1.scheduleAtFixedRate(getData1, 0, 1, TimeUnit.SECONDS);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.tela.getAbrirCaixa())
        {
         scheduler.shutdown();
         dataAbertura = LocalDateTime.now();
         dataFechamento = LocalDateTime.now();
         
         Caixa caixa = new Caixa();
         funcionario funcionario = new funcionario();
         
         caixa.setId(listaCaixa.size()+1);
         caixa.setDataHoraAbertura(dataAbertura);
         caixa.setValorAbertura(Float.parseFloat(tela.getSaldoAbertura().getText()));
         funcionario = listaFuncionario.get(tela.getUsuarioBox().getSelectedIndex());
         caixa.setDataHoraFechamento(dataFechamento);
         caixa.setValorFechamento(Float.parseFloat(tela.getSaldoFechamento().getText()));
         caixa.setObservacao(tela.getObservaçãoTexto().getText());
         caixa.setFuncionario(funcionario);
         CaixaService.adicionar(caixa);
        } else if(e.getSource() == this.tela.getFecharCaixa())
        {
            System.out.println("c");
            
            scheduler1.shutdown();
            dataFechamento = LocalDateTime.now();
            
            Caixa caixa = new Caixa();
            caixa.setDataHoraFechamento(dataFechamento);
            caixa.setValorFechamento(Float.parseFloat(tela.getSaldoFechamento().getText()));
            caixa.setObservacao(tela.getObservaçãoTexto().getText());
            caixa.setId(listaCaixa.size());
            
            CaixaService.atualizar(caixa);
        }
    }
    
    }
