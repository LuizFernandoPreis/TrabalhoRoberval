
package Controller;

import Controller.utilities.Utilities;
import Model.bo.MovimentoCaixa;
import View.TelaMovimentoCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ControllerMovimentoCaixa extends Controllers implements ActionListener{
    private TelaMovimentoCaixa tela;
    private LocalDateTime data;
    private List<MovimentoCaixa> listaMovimentoCaixa;
    
    
    
    public ControllerMovimentoCaixa(TelaMovimentoCaixa tela) {
        this.tela = tela;
        Utilities.setDatas(tela.getDataTexto(), tela.getHoraTexto(),this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
    
}
