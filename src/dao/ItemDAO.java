package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Item;

public class ItemDAO {

    public void cadastrar(Item item) {
        String sql = "INSERT INTO itens "
                + "(nome, categoria, efeito, nivel_perigo, status, agente_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setString(3, item.getEfeito());
            stmt.setInt(4, item.getNivelPerigo());
            stmt.setString(5, item.getStatus());
            stmt.setInt(6, item.getAgenteId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Item cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar item!");
            e.printStackTrace();
        }
    }

    public List<Item> listar() {

        List<Item> lista = new ArrayList<>();

        String sql = "SELECT id, nome, categoria, efeito, "
                + "nivel_perigo, status, agente_id FROM itens";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getString("efeito"),
                        rs.getInt("nivel_perigo"),
                        rs.getString("status"),
                        rs.getInt("agente_id")
                );

                lista.add(item);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar itens!");
            e.printStackTrace();
        }

        return lista;
    }

    public void alterar(Item item) {

        String sql = "UPDATE itens SET "
                + "nome = ?, "
                + "categoria = ?, "
                + "efeito = ?, "
                + "nivel_perigo = ?, "
                + "status = ?, "
                + "agente_id = ? "
                + "WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setString(3, item.getEfeito());
            stmt.setInt(4, item.getNivelPerigo());
            stmt.setString(5, item.getStatus());
            stmt.setInt(6, item.getAgenteId());
            stmt.setInt(7, item.getId());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Item alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar item!");
            e.printStackTrace();
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM itens WHERE id = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

            if (linhasAfetadas > 0) {
                System.out.println("Item excluído com sucesso!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir item!");
            e.printStackTrace();
        }

        return false;
    }
}
