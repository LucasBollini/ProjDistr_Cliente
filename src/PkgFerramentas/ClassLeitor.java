package PkgFerramentas;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class ClassLeitor implements Runnable{
        
    @Override
    public void run() {
        String leituraT;
        byte[] leituraB;
        VarsGlobais.rodar = true;
        try{
            while(true){
                leituraT = "";
                try{
                    VarsGlobais.server.setSoTimeout(0);
                    while(true){
                        leituraB = new byte[1];
                        if(VarsGlobais.server.getInputStream().read(leituraB) == -1)
                            throw new IOException();
                        if(new String(leituraB).equals("{") || new String(leituraB).equals("\""))
                            break;
                    }
                    VarsGlobais.server.setSoTimeout(1000);
                    leituraT += new String(leituraB);
                    while(true){
                        leituraB = new byte[10];
                        if(VarsGlobais.server.getInputStream().read(leituraB) == -1)
                            throw new IOException();
                        leituraT += new String(leituraB);
                        try{
                            new JSONObject(leituraT);
                            break;
                        }catch(JSONException e){}
                    }
                }catch(SocketTimeoutException e){}
                
                HandlerIO.escreverRecebimento(leituraT);
            }
        }catch(IOException e){}
        if(VarsGlobais.rodar){
            VarsGlobais.areaLog.append("Conexão perdida\n");
            HandlerJanelas.conexaoPerdida();
            VarsGlobais.rodar = false;
        }
    }
}