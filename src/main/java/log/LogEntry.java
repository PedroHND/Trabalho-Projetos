package log;

import java.time.LocalDateTime;

public class LogEntry {
    private String idc;
    private String operacao;
    private String nome;
    private LocalDateTime timestamp;

    public LogEntry(String idc, String operacao, String nome) {
        this.operacao = operacao;
        this.nome = nome;
        this.idc = idc;
        this.timestamp = LocalDateTime.now();
    }


    public LocalDateTime getTimestamp(){ 
        return timestamp; 
    }

    public String getIdc() {
        return idc;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getNome() {
        return nome;
    }

    
}