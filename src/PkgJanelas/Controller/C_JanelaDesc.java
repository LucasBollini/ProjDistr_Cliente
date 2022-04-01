package PkgJanelas.Controller;

import PkgFerramentas.VarsGlobais;
import PkgJanelas.Model.M_JanelaDesc;
import PkgJanelas.View.V_JanelaDesc;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.json.JSONException;

public class C_JanelaDesc{
    
    M_JanelaDesc model = new M_JanelaDesc();
    V_JanelaDesc view = new V_JanelaDesc(model);
    
    public C_JanelaDesc(String id, String objetivo, Object controller){
        
        VarsGlobais.listaDescs.add(view);
        
        try{
            model.id = id;
            model.controller = (C_AbaServicos) controller;

            switch(objetivo){
                case "aberto":
                    model.param1 = "Aceitar";
                    model.param2 = "andamento";
                    break;
                case "meus":
                    model.param1 = "Encerrar";
                    model.param2 = "fechado";
                    break;
                case "andamento":
                    model.param1 = "Finalizar";
                    model.param2 = "fechado";
                    break;
            }

            model.btnCadastrar.setText(model.param1);
            model.getServico();
            model.preencherDados();

            if(model.validarStatus())
                model.btnCadastrar.setEnabled(false);
            else{
                model.btnCadastrar.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e) {
                        view.remove(model.btnCadastrar);
                        try{
                            if(model.attServico())
                                model.lblRetorno.setText("Sucesso");
                            else
                                model.lblRetorno.setText("Falha");
                        }catch(JSONException ex){
                            VarsGlobais.areaLog.append("JSON Inválido\n");
                        }
                        ((C_JanelaLogado)VarsGlobais.listaControllers.get((VarsGlobais.listaControllers.size() - 1))).refreshAbas();
                        view.revalidate();
                        view.repaint();
                    }
                });
            }
        }catch(JSONException ex){
            VarsGlobais.areaLog.append("JSON Inválido\n");
        }
    }
}