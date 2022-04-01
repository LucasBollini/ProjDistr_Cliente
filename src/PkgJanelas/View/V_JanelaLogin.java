package PkgJanelas.View;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import PkgJanelas.Model.M_JanelaLogin;

public class V_JanelaLogin extends JFrame{    
    
    public JPanel area = new JPanel();
    
    public V_JanelaLogin(M_JanelaLogin model){
                
        area.setPreferredSize(new Dimension(300, 500));
        area.setLayout(null);
        
        JLabel lblInicio = new JLabel("Login");
        lblInicio.setBounds(130, 30, 50, 20);
        area.add(lblInicio);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(75, 75, 50, 20);
        area.add(lblEmail);
        
        model.txtEmail.setBounds(75, 95, 140, 30);
        area.add(model.txtEmail);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(75, 140, 50, 20);
        area.add(lblSenha);
        
        model.txtSenha.setBounds(75, 160, 140, 30);
        area.add(model.txtSenha);
        
        model.btnLogar.setBounds(100, 285, 90, 25);
        area.add(model.btnLogar);
        
        model.btnCadastro.setBounds(90, 320, 110, 25);
        area.add(model.btnCadastro);
        
        model.scrollPane.setBounds(10, 370, 280, 120);
        area.add(model.scrollPane);
        
        setTitle("Client(e)");
        setContentPane(area);
        setResizable(false);
        pack();
    }
}