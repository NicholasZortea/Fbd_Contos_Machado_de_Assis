package br.com.fbd.contosmachadodeassis.interfaces;

import br.com.fbd.contosmachadodeassis.main.Periodico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static br.com.fbd.contosmachadodeassis.utils.JDBCUtil.getConnection;
import java.sql.SQLException;
import java.sql.Statement;

public class PeriodicoDAO implements GenericDAO<Periodico> {

    @Override
    public void insert(Periodico periodico) {
        String sql = "INSERT INTO periodico (nome) VALUES (?)";
        try (
            Connection con = getConnection(); PreparedStatement insertSQL = con.prepareStatement(sql);) {
            insertSQL.setString(1, periodico.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Periodico: " + e.getMessage());
        }
    }

    @Override
    public Periodico findByID(int id) {
        String sql = "SELECT * FROM periodico WHERE id = ?";
        try (
            Connection con = getConnection(); PreparedStatement selectIdSQL = con.prepareStatement(sql);) {
            selectIdSQL.setInt(1, id);
            ResultSet rs = selectIdSQL.executeQuery();
            if (rs.next()) {
                return new Periodico(id, rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Periodico> findByProperty(String property, String value) {
        String sql = "SELECT * FROM periodico WHERE " + property + "  = ?";
        List<Periodico> periodicos = new ArrayList<>();
        try (
            Connection con = getConnection(); PreparedStatement selectPropertySQL = con.prepareStatement(sql);) {
            selectPropertySQL.setString(1, value);
            ResultSet rs = selectPropertySQL.executeQuery();
            while (rs.next()) {
                periodicos.add(new Periodico(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return periodicos;
    }

    public static Periodico findOrCreate(String nome) {
        // Tenta buscar
        String sql = "SELECT id FROM periodico WHERE nome = ?";
        Periodico p = null;
        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            p = rs.next() ? new Periodico(rs.getInt("id"), rs.getString("nome")) : insertAndReturnObject(nome);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return p;
        }
    }

    private static Periodico insertAndReturnObject(String nome){
        String sql = "INSERT INTO periodico (nome) VALUES (?)";
        Periodico p = null;
        try (
            Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, nome);
            statement.executeUpdate();
            p = new Periodico(statement.getGeneratedKeys().getInt(1), nome);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return p;
        }
    }
}
