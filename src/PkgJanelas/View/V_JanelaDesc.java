package PkgJanelas.View;

import PkgJanelas.Model.M_JanelaDesc;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class V_JanelaDesc extends JFrame{
        
    public V_JanelaDesc(M_JanelaDesc model){ 
        
        JPanel area = new JPanel();
        area.setPreferredSize(new Dimension(335, 520));
        area.setLayout(null);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(20, 10, 50, 20);
        area.add(lblTipo);
        
        model.txtTipo.setBounds(20, 30, 300, 30);
        model.txtTipo.setEditable(false);
        area.add(model.txtTipo);
        
        JLabel lblDesc = new JLabel("Desc");
        lblDesc.setBounds(20, 75, 50, 20);
        area.add(lblDesc);
        
        model.txtDesc.setLineWrap(true);
        model.txtDesc.setWrapStyleWord(true);
        model.txtDesc.setEditable(false);
        model.scrollPane.setBounds(20, 95, 300, 80);
        model.scrollPane.setHorizontalScrollBar(null);
        area.add(model.scrollPane);
        
        JLabel lblEndC = new JLabel("Endereço Cliente");
        lblEndC.setBounds(20, 185, 100, 20);
        area.add(lblEndC);
        
        model.txtEndC.setBounds(20, 205, 300, 30);
        model.txtEndC.setEditable(false);
        area.add(model.txtEndC);
        
        JLabel lblData = new JLabel("Data");
        lblData.setBounds(20, 250, 50, 20);
        area.add(lblData);
        
        model.txtData.setBounds(20, 270, 140, 30);
        model.txtData.setEditable(false);
        model.txtData.setEditable(false);
        area.add(model.txtData);
        
        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(180, 250, 50, 20);
        area.add(lblHora);
        
        model.txtHora.setBounds(180, 270, 140, 30);
        model.txtHora.setEditable(false);
        area.add(model.txtHora);
                
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(20, 315, 50, 20);
        area.add(lblValor);
        
        model.txtValor.setBounds(20, 335, 300, 30);
        model.txtValor.setEditable(false);
        area.add(model.txtValor);
        
        JLabel lblEndS = new JLabel("Endereço serviço");
        lblEndS.setBounds(20, 380, 100, 20);
        area.add(lblEndS);
        
        model.txtEndS.setBounds(20, 400, 300, 30);
        model.txtEndS.setEditable(false);
        area.add(model.txtEndS);
        
        model.lblRetorno = new JLabel("",SwingConstants.CENTER);
        model.lblRetorno.setBounds(100,445, 130, 30);
        area.add(model.lblRetorno);
        
        model.btnCadastrar.setBounds(100,445, 130, 30);
        area.add(model.btnCadastrar);
        
        setTitle("Detalhes");
        setContentPane(area);
        setResizable(false);
        pack();
        setVisible(true);
        
    }
}