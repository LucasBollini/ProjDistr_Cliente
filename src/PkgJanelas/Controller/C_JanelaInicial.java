package PkgJanelas.Controller;

import PkgFerramentas.ClassLeitor;
import PkgFerramentas.HandlerJanelas;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_JanelaInicial;
import PkgJanelas.View.V_JanelaInicial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class C_JanelaInicial extends C_Global{
    
    M_JanelaInicial model = new M_JanelaInicial();
    V_JanelaInicial view = new V_JanelaInicial(model);
    
    @Override
    public void reabrir() {
        try{
            VarsGlobais.rodar = false;
            VarsGlobais.server.close();
        }catch(Exception e){}
        HandlerJanelas.reabrir(view, this, model.scrollPane);
    }

    @Override
    public void fechar() {}
    
    public C_JanelaInicial(){
        
        VarsGlobais.listaControllers.add(this);
        
        model.btnConectar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                try{
                    VarsGlobais.areaChat.setText("");
                    VarsGlobais.filaLeituras.clear();
                    model.conectarServer();
                    new Thread(new ClassLeitor()).start();
                    view.setVisible(false);
                    new C_JanelaLogin();
                }catch(Exception ex){
                    VarsGlobais.areaLog.append(ex + "\n");
                }
            }
        });
        
        reabrir();
    }
}