package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class M_JanelaCadastro {
    
    public JScrollPane scrollPane = new JScrollPane();
    
    public JTextField   txtEmail = new JTextField(),
                        txtIp = new JTextField(),
                        txtPorta = new JTextField(),
                        txtSenha = new JTextField(),
                        txtNome = new JTextField(),
                        txtCpf = new JTextField(),
                        txtEnd = new JTextField(),
                        txtFone = new JTextField();
    
    public JButton btnCadastrar = new JButton("Cadastrar");
    
    public void cadastrar(){
        HandlerIO.enviarMsg("{\"id\": \"user\",\"type\": \"create\",\"data\": {\"name\": \"" + txtNome.getText() + "\",\"cpf\": \"" + txtCpf.getText() + "\",\"email\": \"" + txtEmail.getText() + "\",\"password\": \"" + txtSenha.getText() + "\",\"address\": \"" + txtEnd.getText() + "\",\"phone\": \"" + txtFone.getText() + "\"}}");
    }
}