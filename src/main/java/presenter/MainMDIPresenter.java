package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import log.CsvLogWriter;
import log.JsonLogWriter;
import log.LogWriter;
import view.MainMDI;

public class MainMDIPresenter {
    private MainMDI tela = new MainMDI();
    private LogWriter logger;
    
    public MainMDIPresenter(){
        tela.setVisible(true);
        tela.getLogComboBox().setSelectedIndex(0);
        changeLog();
        //Action Listeners
        tela.getSairMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });

        tela.getBuscarUsuariosMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new BuscarUsuariosPresenter();
            }
        });        
       
        tela.getBuscarProdutosMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new BuscarProdutosPresenter(logger);
            }
        });
        
        tela.getAplicarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeLog();
            }
        });
    }    
                  
    public void changeLog(){
        if (tela.getLogComboBox().getSelectedIndex() == 0){
            logger = new CsvLogWriter();
        }
        else if (tela.getLogComboBox().getSelectedIndex() == 1){
            logger = new JsonLogWriter();
        }
    }
    
    
}
