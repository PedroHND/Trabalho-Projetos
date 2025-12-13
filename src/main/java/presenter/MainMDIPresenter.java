package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import log.CsvLogWriter;
import log.JsonLogWriter;
import log.LogWriter;
import model.Usuario;
import view.MainMDI;

public class MainMDIPresenter {
    private MainMDI tela = new MainMDI();
    private LogWriter logger;
    private Usuario usuario;
    
    public MainMDIPresenter(Usuario usuario){
        this.usuario = usuario;
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
                if(usuario.isAdm() == true){
                new BuscarUsuariosPresenter(usuario);
                }else{
                    new BuscarUsuariosUserPresenter(usuario);
                }
            }
        });        
       
        
        tela.getAplicarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeLog();
            }
        });
        
        tela.getListarNotificacaoMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ListaNotificacaoPresenter(usuario);
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
