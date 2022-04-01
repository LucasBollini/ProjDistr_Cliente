package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgFerramentas.VarsGlobais;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class M_AbaServicos {
    
    public String objetivo;
    
    public JSONArray listarServicos() throws JSONException{
        String oquefazer = objetivo;
        String idProvider = "";
        String idCliente = "";
        if(objetivo.equals("andamento"))
            idProvider = VarsGlobais.dadosUsuario[0];
        if(objetivo.equals("meus")){
            idCliente = VarsGlobais.dadosUsuario[0];
            oquefazer = "";
        }
        return new JSONObject(HandlerIO.enviarMsg("{\"id\": \"service\",\"type\": \"list\",\"data\": {\"id\": \"\",\"id_client\": \"\",\"id_provider\": \"\",\"type\": \"\",\"description\": \"\",\"value\": \"\",\"id_user_provider\": \"" + idProvider + "\",\"id_user_client\": \"" + idCliente + "\",\"user_client_place\": \"\",\"service_place\": \"\",\"date\": \"\",\"hour\": \"\",\"status\": \"" + oquefazer + "\"}}")).getJSONObject("data").getJSONArray("services");
    }
}