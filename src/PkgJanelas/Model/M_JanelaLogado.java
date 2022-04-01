package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgJanelas.Controller.C_AbaCadServ;
import PkgJanelas.Controller.C_AbaChat;
import PkgJanelas.Controller.C_AbaDados;
import PkgJanelas.Controller.C_AbaServicos;
import PkgJanelas.Controller.C_AbaUsuarios;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import org.json.JSONException;
import org.json.JSONObject;

public class M_JanelaLogado {
    
    public JScrollPane scrollPane = new JScrollPane();
    
    public C_AbaDados abaDados = new C_AbaDados();
    
    public C_AbaCadServ abaCadServ = new C_AbaCadServ();
    
    public C_AbaServicos abasServicos[] = new C_AbaServicos[]{new C_AbaServicos("meus"),new C_AbaServicos("aberto"),new C_AbaServicos("andamento")};
    
    public C_AbaUsuarios abaUsuarios = new C_AbaUsuarios();
    
    public C_AbaChat abaChat = new C_AbaChat();
    
    public JButton  btnLogout = new JButton("Logout"),
                    btnRefresh = new JButton("Refresh");
    
    public void logout() throws JSONException{
        if(!(new JSONObject(HandlerIO.enviarMsg("{\"id\": \"logout\"}"))).get("id").equals("success"))
            throw new JSONException("");
    }
}