package PkgJanelas.Controller;

import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaDados;
import PkgJanelas.View.V_AbaDados;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.json.JSONException;

public class C_AbaDados {
    
    M_AbaDados model = new M_AbaDados();
    public V_AbaDados view = new V_AbaDados(model);
    
    public C_AbaDados(){
        
        try{
            model.escreverDados();
        }catch(JSONException ex){
            VarsGlobais.areaLog.append("JSON Inválido\n");
        }
        
        model.btnAtualizar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                model.btnAtualizar.setEnabled(false);
                model.btnAtualizar.setEnabled(true);
                model.atualizar();
            }
        });
        
    }
}