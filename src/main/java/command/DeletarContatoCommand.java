package command;

import model.Usuario;
import repository.IUsuarioRepository;

public class DeletarContatoCommand implements ICommand {
    private Usuario usuario;
    private IUsuarioRepository repositorio;
    
    
    @Override
    public void execute() {
        this.repositorio.deleteUsuario(usuario);
    }

    public DeletarContatoCommand(Usuario usuario, IUsuarioRepository repositorio) {
        this.usuario = usuario;
        this.repositorio = repositorio;
    }

    public void setProduto(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}