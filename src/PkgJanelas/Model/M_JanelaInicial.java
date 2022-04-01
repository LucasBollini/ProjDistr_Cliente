package PkgJanelas.Model;

import PkgFerramentas.VarsGlobais;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class M_JanelaInicial {
    
    public JScrollPane scrollPane = new JScrollPane();
    
    public JTextField   txtIp = new JTextField(),
                        txtPorta = new JTextField();
    
    public JButton btnConectar = new JButton("Conectar");
    
    public void conectarServer() throws IOException{
        VarsGlobais.server = new Socket();
        VarsGlobais.server.connect(new InetSocketAddress(txtIp.getText(), Integer.parseInt(txtPorta.getText())), 3000);
        VarsGlobais.server.setSoTimeout(3000);
    }
}