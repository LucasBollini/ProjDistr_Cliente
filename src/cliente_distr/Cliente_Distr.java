package cliente_distr;

import PkgJanelas.Controller.C_JanelaInicial;

public class Cliente_Distr {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.d3d","false");
        new C_JanelaInicial();
    }
}