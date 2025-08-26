package command;

import model.Produto;
import repository.IProdutoRepository;

public class DeletarProdutoCommand implements ICommand {
    private Produto produto;
    private IProdutoRepository repositorio;
    
    
    @Override
    public void execute() {
        this.repositorio.deleteProduto(produto);
    }

    public DeletarProdutoCommand(Produto produto, IProdutoRepository repositorio) {
        this.produto = produto;
        this.repositorio = repositorio;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
