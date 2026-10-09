package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Agente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgenteDAO {

    public void cadastrar(Agente agente) {

        String sql = "INSERT INTO agente "
                + "(nome, codinome, classe, nivel, vida, sanidade, origem, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, agente.getNome());
            stmt.setString(2, agente.getCodinome());
            stmt.setString(3, agente.getClasse());
            stmt.setInt(4, agente.getNivel());
            stmt.setInt(5, agente.getVida());
            stmt.setInt(6, agente.getSanidade());
            stmt.setString(7, agente.getOrigem());
            stmt.setString(8, agente.getStatus());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Agente cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar agente!");
            e.printStackTrace();
        }
    }

    public List<Agente> listar() {

        List<Agente> lista = new ArrayList<>();

        String sql = "SELECT id, nome, codinome, classe, nivel, vida, sanidade, origem, status "
                + "FROM agente";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Agente agente = new Agente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codinome"),
                        rs.getString("classe"),
                        rs.getInt("nivel"),
                        rs.getInt("vida"),
                        rs.getInt("sanidade"),
                        rs.getString("origem"),
                        rs.getString("status")
                );

                lista.add(agente);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar agentes!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Agente agente) {

        String sql = "UPDATE agente SET "
                + "nome = ?, "
                + "codinome = ?, "
                + "classe = ?, "
                + "nivel = ?, "
                + "vida = ?, "
                + "sanidade = ?, "
                + "origem = ?, "
                + "status = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, agente.getNome());
            stmt.setString(2, agente.getCodinome());
            stmt.setString(3, agente.getClasse());
            stmt.setInt(4, agente.getNivel());
            stmt.setInt(5, agente.getVida());
            stmt.setInt(6, agente.getSanidade());
            stmt.setString(7, agente.getOrigem());
            stmt.setString(8, agente.getStatus());
            stmt.setInt(9, agente.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Agente alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar agente!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM agente WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Agente excluído com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir agente!");
            e.printStackTrace();
        }

        return false;
    }
}
