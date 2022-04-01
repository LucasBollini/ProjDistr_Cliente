package PkgJanelas.Controller;

import PkgFerramentas.HandlerJanelas;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_JanelaCadastro;
import PkgJanelas.View.V_JanelaCadastro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class C_JanelaCadastro extends C_Global{
    
    M_JanelaCadastro model = new M_JanelaCadastro();
    V_JanelaCadastro view = new V_JanelaCadastro(model);
    
    @Override
    public void reabrir() {
        HandlerJanelas.reabrir(view, this, model.scrollPane);
    }

    @Override
    public void fechar() {
        HandlerJanelas.fechar(view, this);
    }
    
    public C_JanelaCadastro(){
        
        VarsGlobais.listaControllers.add(this);
        
        model.btnCadastrar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnCadastrar.setEnabled(false);
                model.btnCadastrar.setEnabled(true);
                model.cadastrar();
            }
        });
        
        view.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });
        
        reabrir();
    }
}