package observer;

import javax.swing.table.DefaultTableModel;
import repository.UsuarioRepository;
import view.BuscarUsuarios;


public class UsuariosTableObserver implements Subscriber {
    private BuscarUsuarios tela;
    private UsuarioRepository repositorio;

    public UsuariosTableObserver(BuscarUsuarios tela, UsuarioRepository repositorio) {
        this.tela = tela;
        this.repositorio = repositorio;
    }

    
    
    @Override
    public void update() {
        DefaultTableModel model = (DefaultTableModel) tela.getUsuariosTable().getModel();
        model.setRowCount(0);
        for(int i = 0; i < repositorio.getInstance().getUsuariosRepository().size(); i++){
            model.addRow(
                    new Object[]{
                    repositorio.getInstance().getUsuariosRepository().get(i).getNome(),
                    repositorio.getInstance().getUsuariosRepository().get(i).getEmail(),
                    repositorio.getInstance().getUsuariosRepository().get(i).getTelefone(),
                    repositorio.getInstance().getUsuariosRepository().get(i).isComprador(),
                    repositorio.getInstance().getUsuariosRepository().get(i).isVendedor()
                    });
                    }         
        }
    }
    
