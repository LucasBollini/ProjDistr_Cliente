package PkgFerramentas;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class HandlerIO {
    
    public static synchronized String enviarMsg(String msg){
        try{
            VarsGlobais.areaLog.append("E - " + msg + "\n");
            VarsGlobais.server.getOutputStream().write(msg.getBytes());
            while(VarsGlobais.filaLeituras.isEmpty())
                if(!VarsGlobais.rodar)
                    throw new IOException();
            String leitura = VarsGlobais.filaLeituras.get(0);
            VarsGlobais.filaLeituras.remove(0);
            return leitura;
        }catch(IOException e){
            VarsGlobais.areaLog.append("Conexao Perdida\n");
            return "erro";
        }
    }
    
    public static void escreverRecebimento(String leitura){
        VarsGlobais.areaLog.append("R - " + leitura + "\n");
        try{
            if((new JSONObject(leitura)).get("id").equals("chat")){
                JSONObject objTemp = new JSONObject(leitura).getJSONObject("data");
                VarsGlobais.areaChat.append(objTemp.getString("ip") + ": " + objTemp.getString("message") + "\n");
            }
            else
                VarsGlobais.filaLeituras.add(leitura);
        }catch(JSONException e){
            VarsGlobais.areaLog.append("JSON Inválido\n");
            VarsGlobais.filaLeituras.add("erro");
        }
    }
}