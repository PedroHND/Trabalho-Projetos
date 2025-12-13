package presenter;

import command.AdicionarContatoCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import model.Notificacao;
import model.Usuario;
import repository.UsuarioRepository;
import view.Login;

public class LoginPresenter {
    private Login tela = new Login();
    private AdicionarContatoCommand comando;
    private UsuarioRepository repositorio;
    private PopupPresenter erro;

    public LoginPresenter() {
        tela.setVisible(true);
        repositorio = repositorio.getInstance();
        
        //Action Listeners
        tela.getCancelarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        
        tela.getLogarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(repositorio.getUsuariosRepository().isEmpty()){
                    double novoId = repositorio.getInstance().gerarID();
                    String login = tela.getUsuarioTextField().getText();
                    String senha = new String(tela.getSenhaTextField().getPassword());
                    Map<String,String> credenciais = new HashMap();
                    credenciais.put(login, senha);
                    Usuario usuario = new Usuario(novoId, 
                            tela.getUsuarioTextField().getText(),                                                
                            credenciais,
                            login
                    );
                    usuario.setAdm(true);
                    usuario.getMensagens().add(new Notificacao(usuario, usuario, "PARABÉNS, VOCÊS SÃO BIXAS"));
                    comando = new AdicionarContatoCommand(usuario, repositorio.getInstance());
                    comando.execute();
                        MainMDIPresenter main = new MainMDIPresenter(usuario);
                        tela.dispose();

                }
                else{
                    Map<String, String> login = new HashMap();
                    login.put(tela.getUsuarioTextField().getText(), tela.getSenhaTextField().getText());
                    for (Usuario usuario: repositorio.getUsuariosRepository()){
                        if(login.equals(usuario.getCredenciais())){
                            MainMDIPresenter main = new MainMDIPresenter(usuario);
                            tela.dispose();
                        }
                        else {
                            erro = new PopupPresenter("Usuario não encontrado");
                            tela.getUsuarioTextField().setText("");
                            tela.getSenhaTextField().setText("");
                        }
                    }
                
                }
                    
            }
        });        
    }
    
    
}
