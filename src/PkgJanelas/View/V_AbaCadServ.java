package PkgJanelas.View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_AbaCadServ;

public class V_AbaCadServ extends JPanel{
    
    public V_AbaCadServ(M_AbaCadServ model){
        
        setLayout(null);
        
        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(20, 10, 50, 20);
        add(lblTipo);
        
        model.txtTipo.setBounds(20, 30, 300, 30);
        add(model.txtTipo);
        
        JLabel lblDesc = new JLabel("Descrição");
        lblDesc.setBounds(20, 75, 150, 20);
        add(lblDesc);
        
        model.txtDesc = new JTextArea();
        model.txtDesc.setLineWrap(true);
        model.txtDesc.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(model.txtDesc);
        scroll.setBounds(20, 95, 300, 80);
        scroll.setHorizontalScrollBar(null);
        add(scroll);
        
        JLabel lblEndC = new JLabel("Endereço Cliente");
        lblEndC.setBounds(20, 185, 150, 20);
        add(lblEndC);
        
        model.txtEndC.setBounds(20, 205, 300, 30);
        model.txtEndC.setText(VarsGlobais.dadosUsuario[5]);
        add(model.txtEndC);
        
        JLabel lblData = new JLabel("Data");
        lblData.setBounds(20, 250, 50, 20);
        add(lblData);
        
        model.datePicker.setBounds(20, 270, 140, 30);
        add(model.datePicker);
        
        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(180, 250, 50, 20);
        add(lblHora);
        
        model.timePicker.setBounds(180, 270, 140, 30);
        add(model.timePicker);
                
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(20, 315, 50, 20);
        add(lblValor);
        
        model.valorPicker.setBounds(20, 335, 300, 30);
        add(model.valorPicker);
        
        JLabel lblEndS = new JLabel("Endereço Serviço");
        lblEndS.setBounds(20, 380, 150, 20);
        add(lblEndS);
        
        model.txtEndS.setBounds(20, 400, 300, 30);
        add(model.txtEndS);
        
        
        model.btnCadastrar.setBounds(400,400, 120, 30);
        add(model.btnCadastrar);      
    }
}