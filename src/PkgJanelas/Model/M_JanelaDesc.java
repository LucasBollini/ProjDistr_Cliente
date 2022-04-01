package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Controller.C_AbaServicos;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class M_JanelaDesc {
    
    public String id, param1, param2;
    public C_AbaServicos controller;
    
    public JTextArea txtDesc = new JTextArea();
    public JScrollPane scrollPane = new JScrollPane(txtDesc);
    public JTextField   txtTipo = new JTextField(),
                        txtValor = new JTextField(),
                        txtEndC = new JTextField(),
                        txtEndS = new JTextField(),
                        txtData = new JTextField(),
                        txtHora = new JTextField();
    public JLabel lblRetorno = new JLabel("");
    
    public JButton btnCadastrar = new JButton();
    
    public JSONArray dados;
    
    public boolean attServico() throws JSONException{
        String provedor = VarsGlobais.dadosUsuario[0];
        if(param2.equals("fechado"))
            provedor = "";
        return (new JSONObject(HandlerIO.enviarMsg("{\"id\": \"service\",\"type\": \"update\",\"data\": {\"id\": \"" + id + "\",\"id_user_provider\": \"" + provedor + "\",\"status\": \"" + param2 + "\"}}")).getString("id").equals("success"));
    }
    
    public boolean validarStatus() throws JSONException{
        return (dados.getJSONObject(0).get("status").equals("fechado") && param2.equals("fechado")) || (dados.getJSONObject(0).get("status").equals("andamento") && param2.equals("andamento"));
    }
    
    public void getServico() throws JSONException{
        dados = new JSONObject(HandlerIO.enviarMsg("{\"id\": \"service\",\"type\": \"list\",\"data\": {\"id\": \"" + id + "\",\"id_client\": \"\",\"id_provider\": \"\",\"type\": \"\",\"description\": \"\",\"value\": \"\",\"id_user_provider\": \"\",\"id_user_client\": \"\",\"user_client_place\": \"\",\"service_place\": \"\",\"date\": \"\",\"hour\": \"\",\"status\": \"\"}}")).getJSONObject("data").getJSONArray("services");
    }
    
    public void preencherDados(){
        try{ txtTipo.setText(   dados.getJSONObject(0).get("type") + "");               }catch(Exception e){}
        try{ txtDesc.setText(   dados.getJSONObject(0).get("description") + "");        }catch(Exception e){}
        try{ txtValor.setText(  dados.getJSONObject(0).get("value") + "");              }catch(Exception e){}
        try{ txtEndC.setText(   dados.getJSONObject(0).get("user_client_place") + "");  }catch(Exception e){}
        try{ txtEndS.setText(   dados.getJSONObject(0).get("service_place") + "");      }catch(Exception e){}
        try{ txtData.setText(   dados.getJSONObject(0).get("date") + "");               }catch(Exception e){}
        try{ txtHora.setText(   dados.getJSONObject(0).get("hour") + "");               }catch(Exception e){}
    }
}