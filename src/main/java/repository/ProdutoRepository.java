package repository;

import java.util.ArrayList;
import model.Produto;

public class ProdutoRepository implements IProdutoRepository {
    private static ProdutoRepository instance;
    private ArrayList<Produto> produtosRepository;
    private double idAtual;
    
    @Override
    public void addProduto(Produto produto) {
        produtosRepository.add(produto);
    }

    @Override
    public void deleteProduto(Produto produto) {
        produtosRepository.remove(produto);
    }

    @Override
    public void updateProduto(Produto produto) {
            for(int i = 0; i > produtosRepository.size(); i++){
                if(produto.getId() == produtosRepository.get(i).getId()){
                    produtosRepository.remove(i);
                    produtosRepository.add(i, produto);
                }
            }
        }
    
    public static ProdutoRepository getInstance(){
        if (instance == null){
            instance = new ProdutoRepository();
        }
        return instance;
    }

    private ProdutoRepository() {
        produtosRepository = new ArrayList<Produto>();
        this.idAtual = 0;
    }
    
    public double gerarID(){
        this.idAtual++;
        return this.idAtual;
    }

    public double getIdAtual() {
        return idAtual;
    }

    public ArrayList<Produto> getProdutosRepository() {
        return produtosRepository;
    }
    
    
    
}
    

