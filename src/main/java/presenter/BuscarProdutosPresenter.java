package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import log.LogWriter;
import repository.UsuarioRepository;
import view.BuscarProdutos;

public class BuscarProdutosPresenter {
    private BuscarProdutos tela;
    private UsuarioRepository repositorio;
    
    public BuscarProdutosPresenter(LogWriter log){
        tela = new BuscarProdutos();
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
                new AdicionarProdutoPresenter(tela, log);
            }
        });
        
        tela.getVisualizarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int row = tela.getUsuariosTable().getSelectedRow();               
                //new VizualizarUsuarioPresenter(tela, repositorio.getInstance().getUsuariosRepository().get(row));
            }
        });

        
    }

}
