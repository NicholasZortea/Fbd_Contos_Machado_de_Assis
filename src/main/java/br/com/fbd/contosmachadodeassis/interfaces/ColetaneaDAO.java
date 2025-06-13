package br.com.fbd.contosmachadodeassis.interfaces;

import br.com.fbd.contosmachadodeassis.main.Coletanea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static br.com.fbd.contosmachadodeassis.utils.JDBCUtil.getConnection;

public class ColetaneaDAO implements GenericDAO<Coletanea> {
    @Override
    public void insert(Coletanea coletanea) {
        String sql = "INSERT INTO coletanea (nome) VALUES (?)";
        try (
                Connection con = getConnection();
                PreparedStatement insertSQL = con.prepareStatement(sql);
        ) {
            insertSQL.setString(1, coletanea.getNome());
            insertSQL.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Coletanea findByID(int id) {
        String sql = "SELECT * FROM coletanea WHERE id = ?";
        try (
            Connection con = getConnection();
            PreparedStatement selectIdSQL = con.prepareStatement(sql);
        ) {
            selectIdSQL.setInt(1, id);
            ResultSet rs = selectIdSQL.executeQuery();
            if (rs.next()) {
                return new Coletanea(rs.getInt("id"), rs.getString("nome"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Coletanea> findByProperty(String property, String value) {
        String sql = "SELECT * FROM coletanea WHERE " + property + " = ?";
        try (
            Connection con = getConnection();
            PreparedStatement selectPropertySQL = con.prepareStatement(sql);
        ) {
            selectPropertySQL.setString(1, value);
            ResultSet rs = selectPropertySQL.executeQuery();
            List<Coletanea> coletaneas = new ArrayList<>();
            while(rs.next()) {
                coletaneas.add(new Coletanea(rs.getInt("id"), rs.getString("nome")));
            }
            return coletaneas;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
