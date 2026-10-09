package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RelatorioDAO {

    public String relatorioMissoesPorRisco() {
        StringBuilder resultado = new StringBuilder();

        String sql = "SELECT grau_risco, COUNT(*) AS total "
                + "FROM missao "
                + "GROUP BY grau_risco "
                + "ORDER BY grau_risco";

        try ( Connection conexao = Conexao.conectar();  PreparedStatement stmt = conexao.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            resultado.append("RELATÓRIO DE MISSÕES POR GRAU DE RISCO\n\n");

            while (rs.next()) {
                resultado.append(rs.getString("grau_risco"))
                        .append(": ")
                        .append(rs.getInt("total"))
                        .append(" missão(ões)\n");
            }

            if (resultado.toString().endsWith("\n\n")) {
                resultado.append("Nenhuma missão cadastrada.\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao consultar as missões no banco de dados.";
        }

        return resultado.toString();
    }

    public String relatorioAgentesBaixaSanidade() {
        StringBuilder resultado = new StringBuilder();

        String sql = "SELECT nome, sanidade "
                + "FROM agente "
                + "WHERE sanidade <= 30 "
                + "ORDER BY sanidade ASC";

        try ( Connection conexao = Conexao.conectar();  PreparedStatement stmt = conexao.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            resultado.append("AGENTES COM BAIXA SANIDADE\n\n");

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;

                resultado.append("Agente: ")
                        .append(rs.getString("nome"))
                        .append("\nSanidade: ")
                        .append(rs.getInt("sanidade"))
                        .append("\n\n");
            }

            if (!encontrou) {
                resultado.append("Nenhum agente com sanidade igual ou inferior a 30.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao consultar agentes no banco de dados.";
        }

        return resultado.toString();
    }

    public String relatorioEntidadesRecorrentes() {
        StringBuilder resultado = new StringBuilder();

        String sql = "SELECT a.nome, COUNT(o.id) AS total "
                + "FROM ameaca a "
                + "INNER JOIN ocorrencia o ON o.ameaca_id = a.id "
                + "GROUP BY a.id, a.nome "
                + "ORDER BY total DESC, a.nome ASC";

        try ( Connection conexao = Conexao.conectar();  PreparedStatement stmt = conexao.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            resultado.append("ENTIDADES MAIS RECORRENTES\n\n");

            boolean encontrou = false;
            int posicao = 1;

            while (rs.next()) {
                encontrou = true;

                resultado.append(posicao)
                        .append(". ")
                        .append(rs.getString("nome"))
                        .append(" - ")
                        .append(rs.getInt("total"))
                        .append(" ocorrência(ões)\n");

                posicao++;
            }

            if (!encontrou) {
                resultado.append("Nenhuma ocorrência vinculada a ameaças foi encontrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao consultar entidades recorrentes no banco de dados.";
        }

        return resultado.toString();
    }

}
