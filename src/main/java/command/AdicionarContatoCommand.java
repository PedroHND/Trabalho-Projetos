package command;

import model.Usuario;
import repository.UsuarioRepository;

public class AdicionarContatoCommand implements ICommand {
    private Usuario usuario;
    private UsuarioRepository repositorio;
    
    
    @Override
    public void execute() {
        this.repositorio.addUsuario(usuario);
    }

    public AdicionarContatoCommand(Usuario usuario, UsuarioRepository repositorio) {
        this.usuario = usuario;
        this.repositorio = repositorio;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
