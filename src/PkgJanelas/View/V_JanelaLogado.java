package PkgJanelas.View;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import PkgJanelas.Model.M_JanelaLogado;

public class V_JanelaLogado extends JFrame{
    
    public JPanel area = new JPanel();
    
    public V_JanelaLogado(M_JanelaLogado model){
        
        area.setPreferredSize(new Dimension(600, 600));
        area.setLayout(null);
        
        JTabbedPane painelAbas = new JTabbedPane();
        painelAbas.setBounds(10, 10, 580, 470);
        painelAbas.addTab("Perfil", null, model.abaDados.view, null);
        painelAbas.addTab("Cadastrar", null, model.abaCadServ.view, null);
        painelAbas.addTab("Histórico", null, new JScrollPane(model.abasServicos[0].view), null);
        painelAbas.addTab("Abertos", null, new JScrollPane(model.abasServicos[1].view), null);
        painelAbas.addTab("Em Andamento", null, new JScrollPane(model.abasServicos[2].view), null);
        painelAbas.addTab("Pessoas", null, new JScrollPane(model.abaUsuarios.view), null);
        painelAbas.addTab("Chat", null, new JScrollPane(model.abaChat.view), null);
        area.add(painelAbas);
        
        model.btnRefresh.setBounds(485, 490, 110, 25);
        area.add(model.btnRefresh);
        
        model.btnLogout.setBounds(485, 535, 110, 25);
        area.add(model.btnLogout);
        
        model.scrollPane.setBounds(10, 490, 470, 100);
        area.add(model.scrollPane);
        
        setTitle("Área principal");
        setContentPane(area);
        setResizable(false);
        pack();
    }
}