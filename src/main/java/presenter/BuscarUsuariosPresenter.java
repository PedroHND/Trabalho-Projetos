package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Usuario;
import observer.Publisher;
import observer.UsuariosTableObserver;
import repository.UsuarioRepository;
import view.BuscarUsuarios;

public class BuscarUsuariosPresenter {
    private BuscarUsuarios tela;
    private UsuariosTableObserver tableObserver;
    private UsuarioRepository repositorio;
    private Publisher publisher;
    private MensagemPresenter mensagem;
    private Usuario destinatario;
    
    public BuscarUsuariosPresenter(Usuario usuario){
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
        
        tela.getNovoBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AdicionarUsuarioPresenter(tela);
            }
        });
        
        tela.getVisualizarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getUsuariosTable().getSelectedRow();               
                new VizualizarUsuarioPresenter(tela, repositorio.getInstance().getUsuariosRepository().get(row));
            }
        });
        
        tela.getTornarAdmBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getUsuariosTable().getSelectedRow();   
                repositorio.getInstance().getUsuariosRepository().get(row).setAdm(true);
                String mensagemSucesso = new String("O usuário. " + repositorio.getInstance().getUsuariosRepository().get(row).getUsuario() + " agora é um Administrador");  
                JOptionPane.showMessageDialog(null, mensagemSucesso);
                tela.dispose();
                return;
            }
        });
        
        tela.getNotificarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getUsuariosTable().getSelectedRow();
                destinatario = repositorio.getInstance().getUsuariosRepository().get(row);
                mensagem = new MensagemPresenter(usuario, destinatario);
            }
        });
        
        if (usuario.isAdm()){
            tela.getNotificarBtn().setEnabled(true);
        }
        
        
        
    }
}
