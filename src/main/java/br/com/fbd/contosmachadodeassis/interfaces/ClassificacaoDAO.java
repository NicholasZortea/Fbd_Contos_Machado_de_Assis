package br.com.fbd.contosmachadodeassis.interfaces;

import br.com.fbd.contosmachadodeassis.main.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static br.com.fbd.contosmachadodeassis.utils.JDBCUtil.getConnection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassificacaoDAO implements GenericDAO<Classificacao> {

    public static Classificacao findOrCreate(String classificacaoStr) {
        String sqlSelect = "SELECT id FROM classificacao WHERE tipo = ?";
        Classificacao c = null;

        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sqlSelect)) {
            statement.setString(1, classificacaoStr);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                c = new Classificacao(id, classificacaoStr);
            } else {
                c = insertAndReturnObject(classificacaoStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    private static Classificacao insertAndReturnObject(String classificacaoStr) {
        String sqlInsert = "INSERT INTO classificacao (tipo) VALUES (?)";
        Classificacao c = null;

        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, classificacaoStr);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                c = new Classificacao(id, classificacaoStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public void insert(Classificacao classificacao) {
        String sql = "INSERT INTO classificacao (tipo) VALUES (?)";
        try (
            Connection con = getConnection(); PreparedStatement insertSQL = con.prepareStatement(sql);) {
            insertSQL.setString(1, classificacao.getTipo());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Classificacao: " + e.getMessage());
        }
    }

    @Override
    public Classificacao findByID(int id) {
        String sql = "SELECT * FROM classificacao WHERE id = ?";
        try (
            Connection con = getConnection(); PreparedStatement selectIdSQL = con.prepareStatement(sql);) {
            selectIdSQL.setInt(1, id);
            ResultSet rs = selectIdSQL.executeQuery();
            if (rs.next()) {
                return new Classificacao(id, rs.getString("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Classificacao> findByProperty(String property, String value) {
        List<Classificacao> classificacoes = new ArrayList<>();
        String sql = "SELECT * FROM classificacao WHERE " + property + " = ?";
        try (
            Connection con = getConnection(); PreparedStatement selectProperty = con.prepareStatement(sql);) {
            selectProperty.setString(1, value);
            ResultSet rs = selectProperty.executeQuery();
            while (rs.next()) {
                classificacoes.add(new Classificacao(rs.getInt("id"), rs.getString("tipo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classificacoes;
    }

}
