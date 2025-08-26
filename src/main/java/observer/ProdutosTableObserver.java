package observer;

import javax.swing.table.DefaultTableModel;
import repository.ProdutoRepository;
import view.BuscarProdutos;


public class ProdutosTableObserver implements Subscriber {
    private BuscarProdutos tela;
    private ProdutoRepository repositorio;

    public ProdutosTableObserver(BuscarProdutos tela, ProdutoRepository repositorio) {
        this.tela = tela;
        this.repositorio = repositorio;
    }

    
    
    @Override
    public void update() {
        DefaultTableModel model = (DefaultTableModel) tela.getUsuariosTable().getModel();
        model.setRowCount(0);
        for(int i = 0; i < repositorio.getInstance().getProdutosRepository().size(); i++){
            model.addRow(
                    new Object[]{
                    repositorio.getInstance().getProdutosRepository().get(i).getNome(),
                    repositorio.getInstance().getProdutosRepository().get(i).getMassaEstimada(),
                    repositorio.getInstance().getProdutosRepository().get(i).getTipo(),
                    repositorio.getInstance().getProdutosRepository().get(i).getSubcategoria(),
                    repositorio.getInstance().getProdutosRepository().get(i).getVendedor(),
                    repositorio.getInstance().getProdutosRepository().get(i).getPrecoBase(),
                    repositorio.getInstance().getProdutosRepository().get(i).getPrecoDescontado()
                    });
                    }         
        }
    }
    
