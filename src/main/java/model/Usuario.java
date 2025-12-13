package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Usuario {
    private double id;
    private String nome;
    private String usuario;
    private LocalDate dataDeCriacao;
    private Map <String, String> credenciais;
    private boolean adm;
    private ArrayList <Notificacao> mensagens;

    public Usuario(double id, String nome, Map<String, String> credenciais, String usuario) {
        this.id = id;
        this.nome = nome;
        this.dataDeCriacao = LocalDate.now();
        this.credenciais = credenciais;
        this.usuario = usuario;
        this.mensagens = new ArrayList<Notificacao>();
    }


    public double getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public Map<String, String> getCredenciais() {
        return credenciais;
    }

    public boolean isAdm() {
        return adm;
    }

    public String getUsuario() {
        return usuario;
    }

    public ArrayList<Notificacao> getMensagens() {
        return mensagens;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    
      
}