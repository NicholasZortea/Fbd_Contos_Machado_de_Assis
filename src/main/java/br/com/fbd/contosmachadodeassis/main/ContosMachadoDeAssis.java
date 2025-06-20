/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.fbd.contosmachadodeassis.main;

import br.com.fbd.contosmachadodeassis.interfaces.ContoDAO;
import br.com.fbd.contosmachadodeassis.utils.JDBCUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicholas Zortea (zorteanicholas619@gmail.com)
 */
public class ContosMachadoDeAssis {

    public static void main(String[] args) throws IOException, SQLException {
        //System.out.println("Teste de senha: " + JDBCUtil.getProperties());
        Connection connection = JDBCUtil.getConnection();
        connection.close();
        WikiScrapper scrapper = new WikiScrapper();
        ArrayList<Conto> scrapWiki = scrapper.scrapWiki();
        ContoDAO dao = new ContoDAO();
        scrapWiki.forEach((t) -> {
            dao.insert(t);
        });
    }
}
