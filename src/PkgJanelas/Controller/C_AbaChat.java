package PkgJanelas.Controller;

import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaChat;
import PkgJanelas.View.V_AbaChat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class C_AbaChat {
    
    M_AbaChat model = new M_AbaChat();
    public V_AbaChat view = new V_AbaChat(model);
    
    void enviarMsg(){
        try {
            model.enviarMsg();
        } catch (IOException ex) {
            try{
                VarsGlobais.server.close();
            }catch(IOException ex2){}
        }
        model.txtMsg.setText("");
    }
    
    public C_AbaChat(){
        
        model.txtMsg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    enviarMsg();
            }
        });
        
        model.btnEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                enviarMsg();
            }
        });
    }
}