package PkgFerramentas;

import PkgJanelas.Controller.C_Global;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class HandlerJanelas {
    
    public static void reabrir(JFrame view, C_Global controller, JScrollPane scrollPane){
        scrollPane.getViewport().add(VarsGlobais.areaLog);
        view.revalidate();
        view.repaint();
        view.setVisible(true);
    }
    
    public static void fecharDescs(){
        VarsGlobais.listaDescs.forEach(janela -> {janela.dispose();});
        VarsGlobais.listaDescs.clear();
    }
    
    public static void fechar(JFrame view, C_Global controller){
        fecharDescs();
        view.dispose();
        VarsGlobais.listaControllers.remove(controller);
        VarsGlobais.listaControllers.get((VarsGlobais.listaControllers.size() - 1)).reabrir();
    }
    
    public static void conexaoPerdida(){
        fecharDescs();
        while(VarsGlobais.listaControllers.size() > 1)
            VarsGlobais.listaControllers.get(1).fechar();
        VarsGlobais.listaControllers.get(0).reabrir();
    }
}