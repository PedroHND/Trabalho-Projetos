package command;

import model.Produto;
import repository.IProdutoRepository;

public class AdicionarProdutoCommand implements ICommand {
    private Produto produto;
    private IProdutoRepository repositorio;
    
    
    @Override
    public void execute() {
        this.repositorio.addProduto(produto);
    }

    public AdicionarProdutoCommand(Produto produto, IProdutoRepository repositorio) {
        this.produto = produto;
        this.repositorio = repositorio;
    }

    public void setUsuario(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
