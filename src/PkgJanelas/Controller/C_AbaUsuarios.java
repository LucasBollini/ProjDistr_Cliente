package PkgJanelas.Controller;

import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaUsuarios;
import PkgJanelas.View.V_AbaUsuarios;
import org.json.JSONException;

public class C_AbaUsuarios {
    
    M_AbaUsuarios model = new M_AbaUsuarios();
    public V_AbaUsuarios view = new V_AbaUsuarios();
    
    public void listarPessoas(){
        try{
            view.mostrarPessoas(model);
        }catch(JSONException e2){
            VarsGlobais.areaLog.append("JSON Inválido\n");
        }
    }
    
    public C_AbaUsuarios(){
        listarPessoas();
    }
}