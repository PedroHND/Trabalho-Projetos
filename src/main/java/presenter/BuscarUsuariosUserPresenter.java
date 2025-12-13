package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import observer.Publisher;
import observer.UsuariosTableObserver;
import repository.UsuarioRepository;
import view.BuscarUsuarios;

public class BuscarUsuariosUserPresenter {
    private BuscarUsuarios tela;
    private UsuariosTableObserver tableObserver;
    private UsuarioRepository repositorio;
    private Publisher publisher;
    private MensagemPresenter mensagem;
    private Usuario destinatario;
    
    public BuscarUsuariosUserPresenter(Usuario usuario){
        tela = new BuscarUsuarios();
        publisher = new Publisher();
        tableObserver = new UsuariosTableObserver(tela, repositorio.getInstance());
        publisher.addSubscriber(tableObserver);
        publisher.notifySubscribers();
        tela.setVisible(true);
        
        //Action Listeners
        tela.getFecharBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        
        tela.getVisualizarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getUsuariosTable().getSelectedRow();               
                new VizualizarUsuarioPresenter(tela, repositorio.getInstance().getUsuariosRepository().get(row));
            }
        });
        
    }
}
