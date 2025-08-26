package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AdicionarProduto;
import command.AdicionarProdutoCommand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import log.LogEntry;
import log.LogWriter;
import model.Defeito;
import model.Produto;
import observer.ProdutosTableObserver;
import observer.Publisher;
import repository.ProdutoRepository;
import repository.UsuarioRepository;
import view.BuscarProdutos;

public class AdicionarProdutoPresenter {
    private UsuarioRepository repositorioUsuarios;
    private ProdutoRepository repositorioProdutos;
    private AdicionarProduto tela;
    private AdicionarProdutoCommand comando;
    private ProdutosTableObserver observer;
    private Publisher publisher;
    
    public AdicionarProdutoPresenter(BuscarProdutos tela2, LogWriter log){
        publisher = new Publisher();
        tela = new AdicionarProduto();
        observer = new ProdutosTableObserver(tela2, repositorioProdutos.getInstance());
        publisher.addSubscriber(observer);        
        tela.setVisible(true);
        
        
        //Populando as comboBox
        tela.getTipoComboBox().addItem("Vestuário");
        tela.getTipoComboBox().addItem("Calçados");
        tela.getTipoComboBox().addItem("Bolsas e mochilas");
        tela.getTipoComboBox().addItem("Bijuteria e acessórios");
        tela.getTipoComboBox().setSelectedIndex(0);
        atualizarComboBox();
        
        for (int i = 0; i < repositorioUsuarios.getInstance().getUsuariosRepository().size(); i++){
            if(repositorioUsuarios.getInstance().getUsuariosRepository().get(i).isVendedor())
            tela.getVendedorComboBox().addItem(repositorioUsuarios.getInstance().getUsuariosRepository().get(i).getNome());
        }       
        
        //Populando as CheckBox

        
        //Action Listeners
        tela.getTipoComboBox().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atualizarComboBox();
            }
        });
        
        tela.getCancelarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        
        tela.getSalvarBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double novoId = repositorioProdutos.getInstance().gerarID();
                Double doublePreco = Double.parseDouble(tela.getPrecoTextField().getText());
                Double doubleMassa = Double.parseDouble(tela.getPesoTextField().getText());
                JCheckBox[] checks = {
                    tela.getDefeito1CheckBox(),
                    tela.getDefeito2CheckBox(),
                    tela.getDefeito3CheckBox(),
                    tela.getDefeito4CheckBox(),
                    tela.getDefeito5CheckBox(),
                    tela.getDefeito6CheckBox()
                };
                ArrayList<Defeito> defeitos = new ArrayList<Defeito>();
                for (JCheckBox check : checks) {
                    if (check.isSelected()) {
                        defeitos.add(new Defeito (tela.getTipoComboBox().getSelectedItem().toString(),
                        check.getText()
                        ));
                    }
                }
                
                Produto produto = new Produto(novoId,
                        tela.getNomeTextField().getText(),
                        doublePreco,
                        tela.getTipoComboBox().getSelectedItem().toString(),
                        tela.getSubtipoTextField().getText(),
                        "Outro",
                        doubleMassa,
                        defeitos,
                        tela.getVendedorComboBox().getSelectedItem().toString()
                );
                comando = new AdicionarProdutoCommand(produto, repositorioProdutos.getInstance());
                comando.execute();
                publisher.notifySubscribers();
                Double mci = produto.getMCI();
                LogEntry logEntry = new LogEntry(mci.toString(),
                        "Adicionar Produto", 
                        tela.getVendedorComboBox().getSelectedItem().toString()                        
                );
                try {
                    log.writeLog(logEntry);
                } catch (IOException ex) {
                    Logger.getLogger(AdicionarProdutoPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                tela.dispose();                
            }
        });
        
        
    }
        
    private void atualizarComboBox(){
        if("Vestuário".equals(tela.getTipoComboBox().getSelectedItem().toString())){
                tela.getDefeito1CheckBox().setText("Rasgo Estruturante");
                tela.getDefeito2CheckBox().setText("Ausência de Botão Principal");
                tela.getDefeito3CheckBox().setText("Ziper Parcialmente Funcional");
                tela.getDefeito4CheckBox().setText("Mancha Permanente");
                tela.getDefeito5CheckBox().setText("Desgaste por Piling Acentuado");
                tela.getDefeito6CheckBox().setText("");  
                tela.getDefeito6CheckBox().setEnabled(false); 
        }
        else if("Calçados".equals(tela.getTipoComboBox().getSelectedItem().toString())){
                tela.getDefeito1CheckBox().setText("Sola sem Relevo Funcional");
                tela.getDefeito2CheckBox().setText("Descolamento Parcial de Entressola");
                tela.getDefeito3CheckBox().setText("Arranhões Profundos");
                tela.getDefeito4CheckBox().setText("Palmilha Original Ausente");
                tela.getDefeito5CheckBox().setText("Odor Persistente Leve");
                tela.getDefeito6CheckBox().setText("");  
                tela.getDefeito6CheckBox().setEnabled(false);              
        }
        else if("Bolsas e mochilas".equals(tela.getTipoComboBox().getSelectedItem().toString())){
                tela.getDefeito1CheckBox().setText("Alça Reparada");
                tela.getDefeito2CheckBox().setText("Fecho Defeituoso");
                tela.getDefeito3CheckBox().setText("Desbotamento Intenso");
                tela.getDefeito4CheckBox().setText("Foro Rasgado");
                tela.getDefeito5CheckBox().setText(""); 
                tela.getDefeito5CheckBox().setEnabled(false);
                tela.getDefeito6CheckBox().setText("");  
                tela.getDefeito6CheckBox().setEnabled(false);                  
        }
        else if("Bijuteria e acessórios".equals(tela.getTipoComboBox().getSelectedItem().toString())){
                tela.getDefeito1CheckBox().setText("Oxidação Visível");
                tela.getDefeito2CheckBox().setText("Pedra Ausente");
                tela.getDefeito3CheckBox().setText("Fecho Frouxo");
                tela.getDefeito4CheckBox().setText("");
                tela.getDefeito4CheckBox().setEnabled(false);
                tela.getDefeito5CheckBox().setText(""); 
                tela.getDefeito5CheckBox().setEnabled(false);
                tela.getDefeito6CheckBox().setText("");  
                tela.getDefeito6CheckBox().setEnabled(false);                   
        }}
}
