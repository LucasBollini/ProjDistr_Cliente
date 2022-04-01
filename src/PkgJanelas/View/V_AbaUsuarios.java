package PkgJanelas.View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONException;
import PkgJanelas.Model.M_AbaUsuarios;

public class V_AbaUsuarios extends JPanel{
    
    public void mostrarPessoas(M_AbaUsuarios model) throws JSONException{
        JSONArray listaPessoas = model.listarPessoas();
        
        removeAll();
        
        if(listaPessoas != null){
            JPanel modelinho;
            for(int i = 0; i < listaPessoas.length(); i++){
                try{
                    modelinho = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    modelinho.add(new JLabel("Nome: " + listaPessoas.getJSONObject(i).get("name") + " "));
                    modelinho.add(new JLabel("Email: " + listaPessoas.getJSONObject(i).get("email") + ""));
                    modelinho.setBounds(10, (10 + (i * 40)), 500, 40);
                    add(modelinho);
                }catch(Exception ex){}
            }
           setPreferredSize(new Dimension(500, ((40*listaPessoas.length()) + 20)));
        }
        
        revalidate();
        repaint();
    }
    
    public V_AbaUsuarios(){
        setLayout(null);
    }
}