package principal;

import modelo.Agente;
import modelo.Missao;
import modelo.Ocorrencia;
import telas.TelaLogin;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });

    }
}
