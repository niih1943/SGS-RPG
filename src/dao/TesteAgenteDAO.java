package dao;

import modelo.Agente;

public class TesteAgenteDAO {

    public static void main(String[] args) {

        Agente agente = new Agente(
            0,
            "Rafael",
            "Corvo",
            "Combatente",
            1,
            100,
            80,
            "Desconhecida",
            "Ativo"
        );

        AgenteDAO dao = new AgenteDAO();

        dao.cadastrar(agente);

        System.out.println("Teste de cadastro finalizado.");
    }
}