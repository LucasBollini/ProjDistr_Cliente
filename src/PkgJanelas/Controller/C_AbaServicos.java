package PkgJanelas.Controller;

import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaServicos;
import PkgJanelas.View.V_AbaServicos;
import org.json.JSONException;

public class C_AbaServicos {
    
    M_AbaServicos model = new M_AbaServicos();
    public V_AbaServicos view = new V_AbaServicos();
    
    public void attLista(){
        try{
            view.mostrarServicos(model, this);
        }catch(JSONException e){
            VarsGlobais.areaLog.append("JSON Inválido\n");
        }
    }
    
    public C_AbaServicos(String objetivo){
        model.objetivo = objetivo;
        attLista();
    }
}