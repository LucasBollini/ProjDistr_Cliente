package PkgJanelas.Controller;

import PkgJanelas.Model.M_AbaCadServ;
import PkgJanelas.View.V_AbaCadServ;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class C_AbaCadServ {
    
    M_AbaCadServ model = new M_AbaCadServ();
    public V_AbaCadServ view ;
    
    public C_AbaCadServ(){
        model.setupDaBaguncaToda();
        view = new V_AbaCadServ(model);
        
        model.btnCadastrar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnCadastrar.setEnabled(false);
                model.btnCadastrar.setEnabled(true);
                model.cadastrar();
                //janelaMae.refreshAbas();
            }
        });  
    }
}