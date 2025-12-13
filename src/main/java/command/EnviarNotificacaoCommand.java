package command;

import model.Notificacao;
import model.Usuario;

public class EnviarNotificacaoCommand implements ICommand {
    private Notificacao notificacao;
    private Usuario destinatario;
    
    
    @Override
    public void execute() {
        this.destinatario.getMensagens().add(this.notificacao);
    }

    public EnviarNotificacaoCommand(Notificacao notificacao) {
        this.notificacao = notificacao;
        this.destinatario = notificacao.getDestinatario();
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    
    
    
}