package PkgJanelas.View;

import javax.swing.JLabel;
import PkgJanelas.Model.M_AbaDados;

public class V_AbaDados extends JLabel{
            
    public V_AbaDados(M_AbaDados model){

        setLayout(null);
                
        JLabel lblAtuais = new JLabel("Dados Atuais");
        lblAtuais.setBounds(170, 10, 300, 20);
        add(lblAtuais);
        
        for(int i = 0; i < 6; i++){
            model.lblDados[i].setBounds(170, (30 + (65 * i)), 300, 30);
            add(model.lblDados[i]);
        }
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(20, 10, 50, 20);
        add(lblEmail);
        
        model.txtEmail.setBounds(20, 30, 140, 30);
        add(model.txtEmail);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(20, 75, 50, 20);
        add(lblSenha);
        
        model.txtSenha.setBounds(20, 95, 140, 30);
        add(model.txtSenha);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(20, 140, 50, 20);
        add(lblNome);
        
        model.txtNome.setBounds(20, 160, 140, 30);
        add(model.txtNome);
        
        JLabel lblCpf = new JLabel("Cpf");
        lblCpf.setBounds(20, 205, 50, 20);
        add(lblCpf);
        
        model.txtCpf.setBounds(20, 225, 140, 30);
        add(model.txtCpf);
        
        JLabel lblEnd = new JLabel("Endereço");
        lblEnd.setBounds(20, 270, 100, 20);
        add(lblEnd);
        
        model.txtEnd.setBounds(20, 290, 140, 30);
        add(model.txtEnd);
        
        JLabel lblFone = new JLabel("Fone");
        lblFone.setBounds(20, 335, 50, 20);
        add(lblFone);
        
        model.txtFone.setBounds(20, 355, 140, 30);
        add(model.txtFone);
        
        model.btnAtualizar.setBounds(35, 400, 115, 25);
        add(model.btnAtualizar);
        
    }
}