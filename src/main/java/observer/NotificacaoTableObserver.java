package observer;

import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.ListaNotificacao;


public class NotificacaoTableObserver implements Subscriber {
    private ListaNotificacao tela;
    private Usuario usuario;

    public NotificacaoTableObserver(ListaNotificacao tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;   
    }

       
    @Override
    public void update() {
        DefaultTableModel model = (DefaultTableModel) tela.getNotificacaoTable().getModel();
        model.setRowCount(0);
        for(int i = 0; i < usuario.getMensagens().size(); i++){
            model.addRow(
                    new Object[]{
                    usuario.getMensagens().get(i).getRemetente().getUsuario(),
                    usuario.getMensagens().get(i).getDestinatario().getUsuario(),
                    usuario.getMensagens().get(i).getDataDeEnvio().toString(),
                    usuario.getMensagens().get(i).isLida()
                    });                  
        }
    }
}
    
