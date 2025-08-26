package repository;

import model.Produto;


public interface IProdutoRepository {
    public void addProduto (Produto produto);
    public void deleteProduto (Produto produto);
    public void updateProduto (Produto produto);
}
