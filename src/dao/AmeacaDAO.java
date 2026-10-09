package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Ameaca;

public class AmeacaDAO {

    public void cadastrar(Ameaca ameaca) {
        String sql = "INSERT INTO ameaca "
                + "(nome, tipo, elemento, nivel_ameaca, status_aparicao) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, ameaca.getNome());
            stmt.setString(2, ameaca.getTipo());
            stmt.setString(3, ameaca.getElemento());
            stmt.setInt(4, ameaca.getNivelAmeaca());
            stmt.setString(5, ameaca.getStatusAparicao());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Ameaça cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar ameaça!");
            e.printStackTrace();
        }
    }

    public List<Ameaca> listar() {
        List<Ameaca> lista = new ArrayList<>();

        String sql = "SELECT id, nome, tipo, elemento, "
                + "nivel_ameaca, status_aparicao FROM ameaca";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Ameaca ameaca = new Ameaca(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getString("elemento"),
                        rs.getInt("nivel_ameaca"),
                        rs.getString("status_aparicao")
                );

                lista.add(ameaca);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar ameaças!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Ameaca ameaca) {
        String sql = "UPDATE ameaca SET "
                + "nome = ?, "
                + "tipo = ?, "
                + "elemento = ?, "
                + "nivel_ameaca = ?, "
                + "status_aparicao = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, ameaca.getNome());
            stmt.setString(2, ameaca.getTipo());
            stmt.setString(3, ameaca.getElemento());
            stmt.setInt(4, ameaca.getNivelAmeaca());
            stmt.setString(5, ameaca.getStatusAparicao());
            stmt.setInt(6, ameaca.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Ameaça alterada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar ameaça!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM ameaca WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Ameaça excluída com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir ameaça!");
            e.printStackTrace();
        }

        return false;
    }
}
