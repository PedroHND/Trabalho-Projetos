package model;

import java.time.LocalDate;
import java.util.Map;

public class Usuario {
    private double id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataDeCriacao;
    private Map <String, String> credenciais;
    private boolean adm;
    private PerfilComprador perfilComprador;
    private PerfilVendedor perfilVendedor;
    private boolean comprador;
    private boolean vendedor;

    public Usuario(double id, String nome, String email, String telefone, Map <String,String> credenciais, boolean comprador, boolean vendedor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.credenciais = credenciais;
        this.dataDeCriacao = LocalDate.now();
        this.adm = false;
        this.comprador = comprador;
        this.vendedor = vendedor;
        if(comprador == true)
            this.perfilComprador = new PerfilComprador();
        if(vendedor == true)
            this.perfilVendedor = new PerfilVendedor();
    }

    public double getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
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

    public PerfilComprador getPerfilComprador() {
        return perfilComprador;
    }

    public PerfilVendedor getPerfilVendedor() {
        return perfilVendedor;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", dataDeCriacao=" + dataDeCriacao + ", credenciais=" + credenciais + ", adm=" + adm + ", perfilComprador=" + perfilComprador + ", perfilVendedor=" + perfilVendedor + ", comprador=" + comprador + ", vendedor=" + vendedor + '}';
    }

    public boolean isComprador() {
        return comprador;
    }

    public boolean isVendedor() {
        return vendedor;
    }
    
    
    
}
