package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Popup;

public class PopupPresenter {
    private Popup tela = new Popup();

    public PopupPresenter(String menssagem) {
        tela.getErrorText().setText(menssagem);
        
        tela.setVisible(true);
        
        tela.getOkBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tela.dispose();
            }
        });
        
    }
    
    
    
}
