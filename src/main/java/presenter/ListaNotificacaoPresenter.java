package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Notificacao;
import model.Usuario;
import observer.NotificacaoTableObserver;
import observer.Publisher;
import view.ListaNotificacao;

public class ListaNotificacaoPresenter {
    private ListaNotificacao tela = new ListaNotificacao();
    private NotificacaoTableObserver tableObserver;
    private Publisher publisher;

    public ListaNotificacaoPresenter(Usuario usuario) {
        publisher = new Publisher();
        tableObserver = new NotificacaoTableObserver(tela, usuario);
        publisher.addSubscriber(tableObserver);
        publisher.notifySubscribers();                
        tela.setVisible(true);
        
        //Action Listeners
        tela.getSairBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });        
    
        tela.getVizualizarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getNotificacaoTable().getSelectedRow();               
                Notificacao msg = usuario.getMensagens().get(row);
                usuario.getMensagens().get(row).setLida(true);
                publisher.notifySubscribers();
                PopupPresenter mensagem = new PopupPresenter(msg.getMensagem());
            }
        });        
    }
    
    
    
}
