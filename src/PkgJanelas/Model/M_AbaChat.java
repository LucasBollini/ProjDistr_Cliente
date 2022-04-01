package PkgJanelas.Model;

import PkgFerramentas.VarsGlobais;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class M_AbaChat {
    
    public JButton btnEnviar = new JButton("Enviar");
    public JTextField txtMsg = new JTextField();
    
    public void enviarMsg() throws IOException{
        VarsGlobais.server.getOutputStream().write(("{\"id\": \"chat\", \"data\":{\"message\":\"" + txtMsg.getText() + "\"}}").getBytes());
    }
}