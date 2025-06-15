package br.com.fbd.contosmachadodeassis.interfaces;

import br.com.fbd.contosmachadodeassis.main.Coletanea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static br.com.fbd.contosmachadodeassis.utils.JDBCUtil.getConnection;
import java.sql.SQLException;
import java.sql.Statement;

public class ColetaneaDAO implements GenericDAO<Coletanea> {

    public static Coletanea findOrCreate(String nome) {
        String sql = "SELECT id FROM coletanea WHERE nome = ?";
        Coletanea c = null;
        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                c = new Coletanea(id, nome);
            } else {
                c = insertAndReturnColetanea(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    private static Coletanea insertAndReturnColetanea(String nome) {
        String sql = "INSERT INTO coletanea (nome) VALUES (?)";
        Coletanea c = null;
        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, nome);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir a coletânea.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    c = new Coletanea(id, nome);
                } else {
                    throw new SQLException("Falha ao obter o ID da coletânea inserida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void insert(Coletanea coletanea) {
        String sql = "INSERT INTO coletanea (nome) VALUES (?)";
        try (
            Connection con = getConnection(); PreparedStatement insertSQL = con.prepareStatement(sql);) {
            insertSQL.setString(1, coletanea.getNome());
            insertSQL.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Coletanea: " + e.getMessage());
        }
    }

    @Override
    public Coletanea findByID(int id) {
        String sql = "SELECT * FROM coletanea WHERE id = ?";
        try (
            Connection con = getConnection(); PreparedStatement selectIdSQL = con.prepareStatement(sql);) {
            selectIdSQL.setInt(1, id);
            ResultSet rs = selectIdSQL.executeQuery();
            if (rs.next()) {
                return new Coletanea(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Coletanea> findByProperty(String property, String value) {
        String sql = "SELECT * FROM coletanea WHERE " + property + " = ?";
        try (
            Connection con = getConnection(); PreparedStatement selectPropertySQL = con.prepareStatement(sql);) {
            selectPropertySQL.setString(1, value);
            ResultSet rs = selectPropertySQL.executeQuery();
            List<Coletanea> coletaneas = new ArrayList<>();
            while (rs.next()) {
                coletaneas.add(new Coletanea(rs.getInt("id"), rs.getString("nome")));
            }
            return coletaneas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
