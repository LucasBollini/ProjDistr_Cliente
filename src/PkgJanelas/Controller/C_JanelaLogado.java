package PkgJanelas.Controller;

import PkgFerramentas.HandlerJanelas;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_JanelaLogado;
import PkgJanelas.View.V_JanelaLogado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.json.JSONException;

public class C_JanelaLogado extends C_Global{
    
    M_JanelaLogado model = new M_JanelaLogado();
    V_JanelaLogado view = new V_JanelaLogado(model);
        
    @Override
    public void reabrir() {
        HandlerJanelas.reabrir(view, this, model.scrollPane);
    }

    @Override
    public void fechar() {
        HandlerJanelas.fechar(view, this);
    }
    
    private void logout(){
        try{
            model.logout();
            fechar();
        }catch(JSONException ex){
            VarsGlobais.areaLog.append("JSON Inválido\n");
        }
    }
    
    public void refreshAbas(){
        model.abasServicos[0].attLista();
        model.abasServicos[1].attLista();
        model.abasServicos[2].attLista();
        model.abaUsuarios.listarPessoas();
    }
    
    public C_JanelaLogado(){
        
        VarsGlobais.listaControllers.add(this);
        
        model.btnLogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnLogout.setEnabled(false);
                model.btnLogout.setEnabled(true);
                logout();
            }
        });
        
        model.btnRefresh.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnRefresh.setEnabled(false);
                model.btnRefresh.setEnabled(true);
                refreshAbas();
            }
        });
        
        view.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                logout();
            }
        });
        
        reabrir();
    }
}