package repository;

import model.Usuario;


public interface IUsuarioRepository {
    public void addUsuario (Usuario usuario);
    public void deleteUsuario (Usuario usuario);
    public void updateUsuario (Usuario usuario);
}
