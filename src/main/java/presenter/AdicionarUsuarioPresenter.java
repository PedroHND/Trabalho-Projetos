package presenter;

import command.AdicionarContatoCommand;
import view.AdicionarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import model.Usuario;
import observer.Publisher;
import observer.UsuariosTableObserver;
import repository.UsuarioRepository;
import view.BuscarUsuarios;

public class AdicionarUsuarioPresenter {
    private AdicionarUsuario tela;
    private AdicionarContatoCommand comando;
    private UsuariosTableObserver tableObserver;
    private UsuarioRepository repositorio;
    private Publisher publisher;

    public AdicionarUsuarioPresenter(BuscarUsuarios tela2){
        publisher = new Publisher();
        tableObserver = new UsuariosTableObserver(tela2, repositorio.getInstance());
        publisher.addSubscriber(tableObserver);        
        tela = new AdicionarUsuario();
        tela.setVisible(true);
        
        //Action Listeners
        tela.getCancelarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        
        tela.getSalvarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double novoId = repositorio.getInstance().gerarID();
                String login = tela.getUsuarioTextField().getText();
                String senha = new String(tela.getSenhaTextField().getPassword());
                Map<String,String> credenciais = new HashMap();
                credenciais.put(login, senha);
                Usuario usuario = new Usuario(novoId, 
                        tela.getNomeTextField().getText(), 
                        tela.getEmailTextField().getText(),
                        tela.getTelefoneTextField().getText(),
                        credenciais,                         
                        tela.getCompradorCheckBox().isSelected(),
                        tela.getVendedorCheckBox().isSelected()
                );
                comando = new AdicionarContatoCommand(usuario, repositorio.getInstance());
                comando.execute();
                publisher.notifySubscribers();
                tela.dispose();
            }
        });
        
    }
    
    
}
