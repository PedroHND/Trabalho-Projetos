package model;

import java.util.Random;

public class Defeito {
    private String tipoPeca;
    private String descricao;
    private double desconto;

    public Defeito(String tipoPeca, String descricao) {
        this.tipoPeca = tipoPeca;
        this.descricao = descricao;
        this.desconto = calcDesconto();
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDesconto() {
        return desconto;
    }
    
    private double calcDesconto(){     
        Random rand = new Random();
        return (1+rand.nextInt(30));
    }
}
