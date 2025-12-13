package repository;

import java.util.ArrayList;
import model.Usuario;

public class UsuarioRepository implements IUsuarioRepository { 
    private static UsuarioRepository instance;
    private ArrayList<Usuario> usuariosRepository;
    private double idAtual;
    
    @Override
    public void addUsuario(Usuario usuario) {
        usuariosRepository.add(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuariosRepository.remove(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
            for(int i = 0; i > usuariosRepository.size(); i++){
                if(usuario.getId() == usuariosRepository.get(i).getId()){
                    usuariosRepository.remove(i);
                    usuariosRepository.add(i, usuario);
                }
            }
        }
    
    public static UsuarioRepository getInstance(){
        if (instance == null){
            instance = new UsuarioRepository();
        }
        return instance;
    }

    private UsuarioRepository() {
        usuariosRepository = new ArrayList<Usuario>();
        this.idAtual = 0;
    }
    
    public double gerarID(){
        this.idAtual++;
        return this.idAtual;
    }

    public double getIdAtual() {
        return idAtual;
    }

    public ArrayList<Usuario> getUsuariosRepository() {
        return usuariosRepository;
    }
    
    
    
}
    

