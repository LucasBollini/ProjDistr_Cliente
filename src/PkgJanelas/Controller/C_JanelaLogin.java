package PkgJanelas.Controller;

import PkgFerramentas.HandlerJanelas;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_JanelaLogin;
import PkgJanelas.View.V_JanelaLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.json.JSONException;

public class C_JanelaLogin extends C_Global{
    
    M_JanelaLogin model = new M_JanelaLogin();
    V_JanelaLogin view = new V_JanelaLogin(model);
    
    @Override
    public void reabrir() {
        HandlerJanelas.reabrir(view, this, model.scrollPane);
    }

    @Override
    public void fechar() {
        HandlerJanelas.fechar(view, this);
    }
    
    public C_JanelaLogin(){
        
        VarsGlobais.listaControllers.add(this);
        
        model.btnLogar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnLogar.setEnabled(false);
                model.btnLogar.setEnabled(true);
                try{
                    model.logar();
                    view.setVisible(false);
                    new C_JanelaLogado();
                }catch(JSONException ex){
                    VarsGlobais.areaLog.append("JSON Inválido\n");
                }
            }
        });
        
        model.btnCadastro.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnCadastro.setEnabled(false);
                model.btnCadastro.setEnabled(true);
                view.setVisible(false);
                new C_JanelaCadastro();
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