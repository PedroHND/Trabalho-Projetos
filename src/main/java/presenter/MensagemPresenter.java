package presenter;

import command.EnviarNotificacaoCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Notificacao;
import model.Usuario;
import view.Mensagem;

public class MensagemPresenter {
    private Mensagem tela = new Mensagem();
    private Notificacao notificacao;
    private EnviarNotificacaoCommand comando;

    public MensagemPresenter(Usuario remetente, Usuario destinatario) {
        tela.setVisible(true);
    
        //Action Listeners
        tela.getCancelarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });

        tela.getEnviarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                notificacao = new Notificacao(remetente, destinatario, tela.getMsgTextArea().getText());
                comando = new EnviarNotificacaoCommand(notificacao);
                comando.execute();
                tela.dispose();
            }
        });        
    }
    
    
}
