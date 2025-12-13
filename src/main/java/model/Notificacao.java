package model;

import java.time.LocalDate;

public class Notificacao {
    private Usuario remetente;
    private Usuario destinatario;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean lida;

    public Notificacao(Usuario remetente, Usuario destinatario, String mensagem) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.dataDeEnvio = dataDeEnvio.now();
        this.lida = false;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDate getDataDeEnvio() {
        return dataDeEnvio;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
    
    
    
    
}
