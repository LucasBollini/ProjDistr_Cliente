package PkgJanelas.View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaChat;

public class V_AbaChat extends JPanel{
        
    public V_AbaChat(M_AbaChat model){
        
        JScrollPane scroll = new JScrollPane(VarsGlobais.areaChat);
        scroll.setBounds(10, 10, 555, 380);
        add(scroll);
        
        model.txtMsg.setBounds(10, 400, 450, 25);
        add(model.txtMsg);
        
        model.btnEnviar.setBounds(475, 400, 90, 25);
        add(model.btnEnviar);
        
        setLayout(null);
    }
}