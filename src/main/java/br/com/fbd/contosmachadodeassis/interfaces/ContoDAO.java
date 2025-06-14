package br.com.fbd.contosmachadodeassis.interfaces;

import br.com.fbd.contosmachadodeassis.main.Conto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static br.com.fbd.contosmachadodeassis.utils.JDBCUtil.getConnection;
import java.sql.SQLException;


public class ContoDAO implements GenericDAO<Conto> {

    @Override
    public void insert(Conto conto) {
        String sql = "INSERT INTO Conto (titulo, ano_publicacao, nmr_palavras, idColetanea, idPeriodico, idClassificacao)" +
                "VALUES (?,?,?,?,?,?)";
        try (
            Connection con = getConnection();
            PreparedStatement insertSQL = con.prepareStatement(sql);
        ) {
            insertSQL.setString(1, conto.getTitulo());
            insertSQL.setDate(2, conto.getAnoPublicacao());
            insertSQL.setInt(3, conto.getNumPalavras());
            insertSQL.setInt(4, conto.getIdColetanea());
            insertSQL.setInt(5, conto.getIdPeriodico());
            insertSQL.setInt(6, conto.getIdClassificacao());
        }
        catch (SQLException e) {
            System.out.println("Erro ao inserir Conto: " + e.getMessage());
        }
    }

    public Conto findByID(int id) {
        String sql = "SELECT * FROM Conto WHERE idConto = ?";
        try(
            Connection con = getConnection();
            PreparedStatement selectIdSQL = con.prepareStatement(sql);
        ) {
            selectIdSQL.setInt(1, id);
            ResultSet rs = selectIdSQL.executeQuery();
            if(rs.next()) {
                return (new Conto(rs.getInt("id"), rs.getString("titulo"), rs.getDate("ano_publicacao"),
                        rs.getInt("nmr_palavras"), rs.getInt("idColetanea"), rs.getInt("idPeriodico"),
                        rs.getInt("idClassificacao")));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Conto> findByProperty(String property, String value) {
        String sql = "SELECT * FROM Conto WHERE " + property +  " = ?";
        try (
            Connection con = getConnection();
            PreparedStatement selectPropertySQL = con.prepareStatement(sql);
        ) {
            selectPropertySQL.setString(1, value);
            ResultSet rs = selectPropertySQL.executeQuery();
            List<Conto> contos = new ArrayList<Conto>();
            while (rs.next()) {
                contos.add(new Conto(rs.getInt("id"), rs.getString("titulo"), rs.getDate("ano_publicacao"),
                        rs.getInt("nmr_palavras"), rs.getInt("idColetanea"), rs.getInt("idPeriodico"),
                        rs.getInt("idClassificacao")));
            }
            return contos;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
