package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgFerramentas.VarsGlobais;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;

public class M_AbaDados {
    
    public JTextField   txtEmail = new JTextField(),
                        txtIp = new JTextField(),
                        xtPorta = new JTextField(),
                        txtSenha = new JTextField(),
                        txtNome = new JTextField(),
                        txtCpf = new JTextField(),
                        txtEnd = new JTextField(),
                        txtFone = new JTextField();
    
    public JButton btnAtualizar = new JButton("Atualizar");
    
    public JLabel[] lblDados = new JLabel[]{new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()};
    
    public void atualizar(){
        HandlerIO.enviarMsg("{\"id\": \"user\",\"type\": \"update\",\"data\": {\"id\": \"" + VarsGlobais.dadosUsuario[0] + "\",\"name\": \"" + txtNome.getText() + "\",\"cpf\": \"" + txtCpf.getText() + "\",\"email\": \"" + txtEmail.getText() + "\",\"password\": \"" + txtSenha.getText() + "\",\"address\": \"" + txtEnd.getText() + "\",\"phone\": \"" + txtFone.getText() + "\"}}");
    }
    
    private JSONObject pegarDados() throws JSONException{
        return new JSONObject(HandlerIO.enviarMsg("{\"id\": \"user\",\"type\": \"list\",\"data\": {\"id\": \"" + VarsGlobais.dadosUsuario[0] + "\",\"name\": \"\",\"cpf\": \"\",\"email\": \"\",\"password\": \"\",\"address\": \"\",\"phone\": \"\"}}")).getJSONObject("data").getJSONArray("users").getJSONObject(0);
    }
    
    public void escreverDados() throws JSONException{
        JSONObject dados = pegarDados();
        for(int i = 1; i < 7; i++)
            VarsGlobais.dadosUsuario[i] = "";
        if(dados != null){
            try{ VarsGlobais.dadosUsuario[1] = dados.getString("email");    }catch(Exception e){}
            try{ VarsGlobais.dadosUsuario[2] = dados.getString("password"); }catch(Exception e){}
            try{ VarsGlobais.dadosUsuario[3] = dados.getString("name");     }catch(Exception e){}
            try{ VarsGlobais.dadosUsuario[4] = dados.getString("cpf");      }catch(Exception e){}
            try{ VarsGlobais.dadosUsuario[5] = dados.getString("address");  }catch(Exception e){}
            try{ VarsGlobais.dadosUsuario[6] = dados.getString("phone");    }catch(Exception e){}
            for(int i = 0; i < 6; i++)
                lblDados[i].setText(VarsGlobais.dadosUsuario[(i+1)]);
        }
    }
}