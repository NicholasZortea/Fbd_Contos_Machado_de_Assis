/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fbd.contosmachadodeassis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicholas Zortea (zorteanicholas619@gmail.com)
 */
public class JDBCUtil {
    private static Properties props = new Properties();
    private static File jdbcPropertiesFile = new File("jdbc.properties");

    public static final String PASSWORD = "password";
    public static final String URL = "url";
    public static final String USER = "user";
    public static final String DRIVER = "driver";
    
    static {
        try {
            checkFile();
        } catch (IOException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() throws SQLException{
        String user = props.getProperty(USER);
        String password = props.getProperty(PASSWORD);
        String url = props.getProperty(URL);
        return DriverManager.getConnection(url, user, password);
    };

    public static Properties getProperties(){
        return props;
    }

    private static void checkFile() throws IOException{
        if(!jdbcPropertiesFile.exists()){
            createFileAndLoadPropertiesIn();
            throw new IOException("Arquivo de propriedade criado, preencha-o com credenciais corretas");
        }
        loadFileInProperties();
    }
    
    private static void createFileAndLoadPropertiesIn() throws IOException {
        Properties createdProperties = createProperties();
        jdbcPropertiesFile.createNewFile();
        storeProperties(createdProperties);
    }

    private static Properties createProperties(){
        Properties properties = new Properties();
        properties.put(USER, "your_username");
        properties.put(PASSWORD, "your_password");
        properties.put(URL, "jdbc:mysql://localhost:3306/your_database");
        properties.put(DRIVER, "com.mysql.cj.jdbc.Driver");
        return properties;
    }

    private static void storeProperties(Properties props) {
        try (FileOutputStream out = new FileOutputStream(jdbcPropertiesFile)) {
            // Salva no arquivo com um comentário opcional
            props.store(out, "Arquivo de configuração do banco de dados");
            System.out.println("Arquivo config.properties criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadFileInProperties() {
        try (InputStream input = new FileInputStream(jdbcPropertiesFile)) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
