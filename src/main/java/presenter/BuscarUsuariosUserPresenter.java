package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repository.UsuarioRepository;
import view.BuscarUsuarios;

public class BuscarUsuariosPresenter {
    private BuscarUsuarios tela;
    private UsuarioRepository repositorio;
    
    public BuscarUsuariosPresenter(){
        tela = new BuscarUsuarios();
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

        
    }
}
