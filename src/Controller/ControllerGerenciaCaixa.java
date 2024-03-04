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
    private Controllers c = new Controllers(1);


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
        
        testeCaixa();
        setValorFechamento();
        
        this.c.setOn(1);
        System.out.println(this.c.getOn());
        setOn(1);
        Utilities.setDatas(this.tela.getDataAbertura(), this.tela.getHoraAbertura(), this.c);
        Utilities.setDatas(this.tela.getDataFechamento(), this.tela.getHoraFechamento(), this);
        

    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.tela.getAbrirCaixa())
        {
         setOn(0);
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
         caixa.setStatus("a");
         CaixaService.adicionar(caixa);
        } else if(e.getSource() == this.tela.getFecharCaixa())
        {
            
            
            
            setOn(0);
            dataFechamento = LocalDateTime.now();
            
            Caixa caixa = new Caixa();
            caixa.setDataHoraFechamento(dataFechamento);
            caixa.setValorFechamento(Float.parseFloat(tela.getSaldoFechamento().getText()));
            caixa.setObservacao(tela.getObservaçãoTexto().getText());
            caixa.setStatus("cc");
            
            caixa.setId(listaCaixa.size());
            CaixaService.atualizar(caixa);
            
            this.tela.dispose();
        }
    }
    
    
    public void testeCaixa(){
            for(Caixa caixa: listaCaixa){
                if(caixa.getStatus().length() < 2){
                    this.c.setOn(0);
                    this.tela.getSaldoAbertura().setText(""+caixa.getValorAbertura());
                    this.tela.getSaldoAbertura().setEnabled(false);
                    LocalDateTime datas = caixa.getDataHoraAbertura();
                    this.tela.getDataAbertura().setText(""+caixa.getDataHoraAbertura().getDayOfMonth()+"/"+caixa.getDataHoraAbertura().getMonthValue()+"/"+caixa.getDataHoraAbertura().getYear());
                    this.tela.getHoraAbertura().setText(""+datas.getHour() + ":"+datas.getMinute() +":"+ datas.getSecond());
                }
            }
        }

    @Override
    public int getOn() {
        return super.getOn();
    }
    
    @Override
    public void setOn(int on) {
        super.setOn(on);
    }
    
    public void setValorFechamento(){
        for(Caixa caixa : listaCaixa){
            if(caixa.getStatus().length() < 2){
                tela.getSaldoFechamento().setText("" + caixa.getValorFechamento());
                System.out.println(caixa.getValorFechamento());
            }
        }
    }
    }
