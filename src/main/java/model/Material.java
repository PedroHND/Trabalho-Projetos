package model;

public class Material {
    private String material;
    private double fatorDeEmissao;

    public Material(String material) {
        this.material = material;
        this.fatorDeEmissao = getFatorPorMaterial();
    }

    public String getMaterial() {
        return material;
    }

    public double getFatorDeEmissao() {
        return fatorDeEmissao;
    }
    
    private double getFatorPorMaterial(){
        switch (this.material){
            case "Algodão":
                this.fatorDeEmissao = 5.2;
            case "Poliéster":
                this.fatorDeEmissao = 9.5;
            case "Couro":
                this.fatorDeEmissao = 14.8;
            case "Metal Leve":
                this.fatorDeEmissao = 8.6;
            case "Plástico":
                this.fatorDeEmissao = 3.1;
            default:
                this.fatorDeEmissao = 4;
        }
        return 0;
    }
}
