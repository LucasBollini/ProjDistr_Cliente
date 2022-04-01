package PkgJanelas.View;

import PkgJanelas.Controller.C_JanelaDesc;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONArray;
import PkgJanelas.Model.M_AbaServicos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import org.json.JSONException;


public class V_AbaServicos extends JPanel{
    
    public void mostrarServicos(M_AbaServicos model, Object controller) throws JSONException{
        JSONArray listaServicos = model.listarServicos();
        
        removeAll();
        
        if(listaServicos != null){
            JPanel modelinho;
            for(int i = 0; i < listaServicos.length(); i++){
                try{
                    modelinho = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    modelinho.add(new botaoCustom("Abrir",listaServicos.getJSONObject(i).get("id") + "", model.objetivo, controller));
                    modelinho.add(new JLabel(listaServicos.getJSONObject(i).get("status") + " - "));
                    modelinho.add(new JLabel(listaServicos.getJSONObject(i).get("type") + ""));
                    modelinho.setBounds(10, (10 + (i * 40)), 500, 40);
                    add(modelinho);
                }catch(Exception ex){}
            }
            setPreferredSize(new Dimension(500, ((40*listaServicos.length()) + 20)));
        }
        
        revalidate();
        repaint();
    }
    
    
    public V_AbaServicos(){
        setLayout(null);
    }
    
    class botaoCustom extends JButton{
        public botaoCustom(String texto, final String id, final String objetivo, final Object controller){
            setPreferredSize(new Dimension(80, 30));
            setText(texto);
            addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    setEnabled(false);
                    setEnabled(true);
                    new C_JanelaDesc(id, objetivo, controller);
                }
            });
        }
    }
}