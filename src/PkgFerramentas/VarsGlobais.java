package PkgFerramentas;

import PkgJanelas.Controller.C_Global;
import PkgJanelas.View.V_JanelaDesc;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTextArea;

public class VarsGlobais {
    
    public static ArrayList<V_JanelaDesc> listaDescs = new ArrayList<>();
    public static ArrayList<C_Global> listaControllers = new ArrayList<>();
    public static Vector<String> filaLeituras = new Vector<>();
    public static Socket server;
    public static boolean rodar;
    public static JTextArea areaChat = new JTextArea(),
                            areaLog = new JTextArea();
    
    public static String[] dadosUsuario = new String[7];
}