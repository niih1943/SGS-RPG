package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Missao;

public class MissaoDAO {

    public void cadastrar(Missao missao) {
        String sql = "INSERT INTO missao "
                + "(titulo, equipe_id, local, grau_risco, status, inicio, fim) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, missao.getTitulo());
            stmt.setInt(2, missao.getEquipeId());
            stmt.setString(3, missao.getLocal());
            stmt.setString(4, missao.getGrauRisco());
            stmt.setString(5, missao.getStatus());

            stmt.setDate(6, Date.valueOf(converterData(missao.getInicio())));
            stmt.setDate(7, Date.valueOf(converterData(missao.getFim())));

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Missão cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar missão!");
            e.printStackTrace();
        }
    }

    public List<Missao> listar() {
        List<Missao> lista = new ArrayList<>();

        String sql = "SELECT id, titulo, equipe_id, local, "
                + "grau_risco, status, inicio, fim FROM missao";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Missao missao = new Missao(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("equipe_id"),
                        rs.getString("local"),
                        rs.getString("grau_risco"),
                        rs.getString("status"),
                        converterData(rs.getDate("inicio")),
                        converterData(rs.getDate("fim"))
                );

                lista.add(missao);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar missões!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Missao missao) {
        String sql = "UPDATE missao SET "
                + "titulo = ?, "
                + "equipe_id = ?, "
                + "local = ?, "
                + "grau_risco = ?, "
                + "status = ?, "
                + "inicio = ?, "
                + "fim = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, missao.getTitulo());
            stmt.setInt(2, missao.getEquipeId());
            stmt.setString(3, missao.getLocal());
            stmt.setString(4, missao.getGrauRisco());
            stmt.setString(5, missao.getStatus());

            stmt.setDate(6, Date.valueOf(converterData(missao.getInicio())));
            stmt.setDate(7, Date.valueOf(converterData(missao.getFim())));

            stmt.setInt(8, missao.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Missão alterada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar missão!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM missao WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Missão excluída com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir missão!");
            e.printStackTrace();
        }

        return false;
    }

    private String converterData(String data) {
        if (data == null || data.trim().isEmpty()) {
            return null;
        }

        String[] partes = data.split("/");

        return partes[2] + "-" + partes[1] + "-" + partes[0];
    }

    private String converterData(Date data) {
        if (data == null) {
            return "";
        }

        String[] partes = data.toString().split("-");

        return partes[2] + "/" + partes[1] + "/" + partes[0];
    }
}
