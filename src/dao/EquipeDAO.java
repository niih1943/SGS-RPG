package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Equipe;

public class EquipeDAO {

    public void cadastrar(Equipe equipe) {
        String sql = "INSERT INTO equipe (nome, descricao) VALUES (?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getDescricao());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Equipe cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar equipe!");
            e.printStackTrace();
        }
    }

    public List<Equipe> listar() {
        List<Equipe> lista = new ArrayList<>();

        String sql = "SELECT id, nome, descricao FROM equipe";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Equipe equipe = new Equipe(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );

                lista.add(equipe);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar equipes!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Equipe equipe) {
        String sql = "UPDATE equipe SET "
                + "nome = ?, "
                + "descricao = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getDescricao());
            stmt.setInt(3, equipe.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Equipe alterada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar equipe!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM equipe WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Equipe excluída com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir equipe!");
            e.printStackTrace();
        }

        return false;
    }
}
