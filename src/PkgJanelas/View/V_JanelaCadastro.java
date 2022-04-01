package PkgJanelas.View;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import PkgJanelas.Model.M_JanelaCadastro;

public class V_JanelaCadastro extends JFrame{
    
    public JPanel area = new JPanel();
    
    public V_JanelaCadastro(M_JanelaCadastro model){
        
        area.setPreferredSize(new Dimension(300, 600));
        area.setLayout(null);
        
        JLabel lblInicio = new JLabel("Cadastro");
        lblInicio.setBounds(115, 30, 80, 20);
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
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(75, 205, 50, 20);
        area.add(lblNome);
        
        model.txtNome.setBounds(75, 225, 140, 30);
        area.add(model.txtNome);
        
        JLabel lblCpf = new JLabel("Cpf");
        lblCpf.setBounds(75, 270, 50, 20);
        area.add(lblCpf);
        
        model.txtCpf.setBounds(75, 290, 140, 30);
        area.add(model.txtCpf);
        
        JLabel lblEnd = new JLabel("Endereço");
        lblEnd.setBounds(75, 335, 100, 20);
        area.add(lblEnd);
        
        model.txtEnd.setBounds(75, 355, 140, 30);
        area.add(model.txtEnd);
        
        JLabel lblFone = new JLabel("Fone");
        lblFone.setBounds(75, 400, 50, 20);
        area.add(lblFone);
        
        model.txtFone.setBounds(75, 420, 140, 30);
        area.add(model.txtFone);
        
        model.btnCadastrar.setBounds(90, 460, 115, 25);
        area.add(model.btnCadastrar);
        
        model.scrollPane.setBounds(10, 490, 280, 100);
        area.add(model.scrollPane);
        
        setTitle("Client(e)");
        setContentPane(area);
        setResizable(false);
        pack();
    }
}