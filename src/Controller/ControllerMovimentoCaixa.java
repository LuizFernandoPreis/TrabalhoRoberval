
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

public class ControllerMovimentoCaixa implements ActionListener{
    private TelaMovimentoCaixa tela;
    private LocalDateTime data;
    private List<MovimentoCaixa> listaMovimentoCaixa;
    public ControllerMovimentoCaixa(TelaMovimentoCaixa tela) {
        this.tela = tela;
       getData();
    }
    
    public void getData(){
         ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        Runnable getData = () -> {
            data = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            data.format(formato);
            this.tela.getHoraTexto().setText(""+data.getHour() + ":"+data.getMinute() +":"+ data.getSecond());  
            this.tela.getDataTexto().setText(""+data.getDayOfMonth()+"/"+data.getMonthValue()+"/"+data.getYear());
    };
        scheduler.scheduleAtFixedRate(getData, 0, 1, TimeUnit.SECONDS);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
    
}
