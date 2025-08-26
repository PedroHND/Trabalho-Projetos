package model;

import java.util.ArrayList;


public class Produto {
    private double id;
    private String nome;
    private double precoBase;
    private double precoDescontado;
    private double precoMinimo; //5%
    private String tipo;
    private String subcategoria;
    private String composicaoTextil;
    private double massaEstimada; //em gramas
    private ArrayList<Defeito> defeitos;
    private double MCI; //Material Circularity Indicator
    private double GWP; //Global Warming Potential
    private double GWPAvoided; 
    private String vendedor;

    public Produto(double id, String nome, double precoBase, String tipo, String subcategoria, String composicaoTextil, double massaEstimada, ArrayList<Defeito> defeitos, String vendedor) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
        this.precoMinimo = precoBase * 0.05;
        this.tipo = tipo;
        this.subcategoria = subcategoria;
        this.composicaoTextil = composicaoTextil;
        this.massaEstimada = massaEstimada;
        this.defeitos = new ArrayList<Defeito>();
        this.defeitos = defeitos;
        this.vendedor = vendedor;
        this.precoDescontado = calcPrecoDescontado();
        this.MCI = calcMCI();
    }
    
    private double calcPrecoDescontado(){
        double precoFinal = precoBase;
        precoFinal -= precoBase*perdaDeDesconto();
        if (precoFinal > getPrecoMinimo()){
            return precoFinal;
        }
        else
            return getPrecoMinimo();
    }
    
    public double perdaDeDesconto(){
        double desconto = 0;
        if(defeitos != null){
        for (int i = 0; i < defeitos.size(); i++){
            desconto += defeitos.get(i).getDesconto();
            }
        return desconto/100;
        }
        else
        return desconto;
    }
    
    /*private double calcGWP(){
        double kilo = this.massaEstimada/1000;
        double aux = kilo * this.getTipo().getFatorDeEmissao();
        aux = aux*0.05;
        return aux;
    }
    
    private double getGWPAvoided(){
        return calcGWP() - (calcGWP()*0.05);
    }*/
    
    private double calcMCI(){
        double fatorDeQualidade = 0;
        if(-perdaDeDesconto() < 0.9){
        fatorDeQualidade = 1 + perdaDeDesconto();
        }
        else fatorDeQualidade = 0.1;
        return fatorDeQualidade;
    }
    
    
    
    private double getPrecoMinimo(){
        return precoMinimo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public String getComposicaoTextil() {
        return composicaoTextil;
    }

    public double getMassaEstimada() {
        return massaEstimada;
    }

    public ArrayList<Defeito> getDefeitos() {
        return defeitos;
    }

    public double getMCI() {
        return MCI;
    }

    public double getGWP() {
        return GWP;
    }

    public double getPrecoDescontado() {
        return precoDescontado;
    }

    public double getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVendedor() {
        return vendedor;
    }
    
}
