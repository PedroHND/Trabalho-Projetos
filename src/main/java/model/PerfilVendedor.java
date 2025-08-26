package model;

import java.util.ArrayList;

public class PerfilVendedor {
    private String reputacao;
    private double estrelas;
    private double totalDeVendas;
    private double beneficioClimatico;
    private ArrayList<String> insignias;
    private double denunciasConfirmadas;
    private ArrayList<Produto> catalogoLocal;
    
    public PerfilVendedor() {
        this.reputacao = calcularReputacao();
        this.estrelas = 0;
        this.totalDeVendas = 0;
        this.beneficioClimatico = 0;
        this.insignias = new ArrayList<String>();
        this.denunciasConfirmadas = 0;
    }
    
    private String calcularReputacao(){
        if (this.estrelas <= 5)
            this.reputacao = "Bronze";
        else if (this.estrelas > 5 && this.estrelas <= 10)
            this.reputacao = "Prata";
        else if (this.estrelas > 10)
            this.reputacao = "Ouro";
        return reputacao;
    }
}
