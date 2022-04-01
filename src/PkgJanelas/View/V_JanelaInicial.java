package PkgJanelas.View;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import PkgJanelas.Model.M_JanelaInicial;

public class V_JanelaInicial extends JFrame{
    
    public JPanel area = new JPanel();
    
    public V_JanelaInicial(M_JanelaInicial model){
        
        area.setPreferredSize(new Dimension(270, 175));
        area.setLayout(null);
        
        JLabel lblIp = new JLabel("IP : Porta");
        lblIp.setBounds(10, 10, 70, 20);
        area.add(lblIp);
        
        model.txtIp.setBounds(10, 35, 85, 30);
        area.add(model.txtIp);
        
        model.txtPorta.setBounds(100, 35, 50, 30);
        area.add(model.txtPorta);
        
        model.btnConectar.setBounds(160, 35, 100, 30);
        area.add(model.btnConectar);
        
        model.scrollPane.setBounds(10, 75, 250, 90);
        area.add(model.scrollPane);
        
        setTitle("Client(e)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(area);
        setResizable(false);
        pack();
        
        model.txtIp.setText("127.0.0.1");
        model.txtPorta.setText("20000");
    }
}