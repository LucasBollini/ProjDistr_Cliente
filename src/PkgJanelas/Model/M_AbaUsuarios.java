package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class M_AbaUsuarios {
    
    public JSONArray listarPessoas() throws JSONException{
        return new JSONObject(HandlerIO.enviarMsg("{\"id\": \"user\", \"type\": \"list\",\"data\": {\"id\": \"\",\"name\": \"\",\"cpf\": \"\",\"email\": \"\",\"password\": \"\", \"address\": \"\",\"phone\": \"\"}}")).getJSONObject("data").getJSONArray("users");
    }
}