package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgFerramentas.VarsGlobais;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;

public class M_JanelaLogin {
    
    public JScrollPane scrollPane = new JScrollPane();
    
    public JTextField txtEmail = new JTextField();
    
    public JPasswordField txtSenha = new JPasswordField();
    
    public JButton  btnLogar = new JButton("Logar"),
                    btnCadastro = new JButton("Cadastro");
    
    public void logar() throws JSONException{
        String leitura = HandlerIO.enviarMsg("{\"id\": \"login\",\"data\": {\"email\": \"" + txtEmail.getText() + "\",\"password\": \"" + txtSenha.getText() + "\"}}");
        if((new JSONObject(leitura)).get("id").equals("success"))
            VarsGlobais.dadosUsuario[0] = (new JSONObject(leitura)).getJSONObject("data").getString("id");
        else
            throw new JSONException("");
    }
}