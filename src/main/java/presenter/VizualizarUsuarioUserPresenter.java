package presenter;

import command.AdicionarContatoCommand;
import command.DeletarContatoCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import observer.Publisher;
import observer.UsuariosTableObserver;
import repository.UsuarioRepository;
import view.BuscarUsuarios;
import view.VizualizarUsuario;

public class VizualizarUsuarioUserPresenter {
    private VizualizarUsuario tela;
    private UsuarioRepository repositorio;
    private Publisher publisher;
    private DeletarContatoCommand deletar;
    private AdicionarContatoCommand adicionar;
    private UsuariosTableObserver tableObserver;

    public VizualizarUsuarioUserPresenter(BuscarUsuarios tela2, Usuario usuario) {
        publisher = new Publisher();
        tableObserver = new UsuariosTableObserver(tela2, repositorio.getInstance());
        publisher.addSubscriber(tableObserver);
        tela = new VizualizarUsuario();
        tela.setVisible(true);
        
        tela.getNomeTextBox().setText(usuario.getNome());
        tela.getUsuarioTextBox().setText(usuario.getUsuario());
        tela.getDataTextBox().setText(usuario.getDataDeCriacao().toString());
        
        //Action Listeners
        tela.getFecharBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });        
    
        tela.getExcluirBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                deletar = new DeletarContatoCommand(usuario, repositorio.getInstance());
                deletar.execute();
                publisher.notifySubscribers();
                tela.dispose();
            }
        });

        tela.getEditarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String novoNome = tela.getNomeTextBox().getText();                                
                String novoLogin = tela.getUsuarioTextBox().getText();
                Usuario novoUsuario = new Usuario(usuario.getId(), 
                        novoNome, 
                        usuario.getCredenciais(),
                        novoLogin
                );
                deletar = new DeletarContatoCommand(usuario, repositorio.getInstance());
                deletar.execute();                
                adicionar = new AdicionarContatoCommand(novoUsuario, repositorio.getInstance());
                adicionar.execute();
                publisher.notifySubscribers();
                tela.dispose();
            }
        });
    }   
    
    
}
