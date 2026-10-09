package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Ocorrencia;

public class OcorrenciaDAO {

    public void cadastrar(Ocorrencia ocorrencia) {

        String sql = "INSERT INTO ocorrencia "
                + "(descricao, impacto_narrativo, impacto_sanidade, missao_id, ameaca_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, ocorrencia.getDescricao());
            stmt.setString(2, ocorrencia.getImpactoNarrativo());
            stmt.setString(3, ocorrencia.getImpactoSanidade());
            stmt.setInt(4, ocorrencia.getMissaoId());
            stmt.setInt(5, ocorrencia.getAmeacaId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Ocorrência cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar ocorrência!");
            e.printStackTrace();
        }
    }

    public List<Ocorrencia> listar() {

        List<Ocorrencia> lista = new ArrayList<>();

        String sql = "SELECT id, descricao, impacto_narrativo, "
                + "impacto_sanidade, missao_id, ameaca_id "
                + "FROM ocorrencia";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Ocorrencia ocorrencia = new Ocorrencia(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("impacto_narrativo"),
                        rs.getString("impacto_sanidade"),
                        rs.getInt("missao_id"),
                        rs.getInt("ameaca_id")
                );

                lista.add(ocorrencia);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar ocorrências!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Ocorrencia ocorrencia) {

        String sql = "UPDATE ocorrencia SET "
                + "descricao = ?, "
                + "impacto_narrativo = ?, "
                + "impacto_sanidade = ?, "
                + "missao_id = ?, "
                + "ameaca_id = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, ocorrencia.getDescricao());
            stmt.setString(2, ocorrencia.getImpactoNarrativo());
            stmt.setString(3, ocorrencia.getImpactoSanidade());
            stmt.setInt(4, ocorrencia.getMissaoId());
            stmt.setInt(5, ocorrencia.getAmeacaId());
            stmt.setInt(6, ocorrencia.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Ocorrência alterada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar ocorrência!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM ocorrencia WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Ocorrência excluída com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir ocorrência!");
            e.printStackTrace();
        }

        return false;
    }
}
