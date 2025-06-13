package br.com.fbd.contosmachadodeassis.main;

import br.com.fbd.contosmachadodeassis.interfaces.ContoDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContoDAO contoDAO = new ContoDAO();
        List<Conto> c = contoDAO.findByProperty("titulo", "Frei Simão");
        System.out.println(c.toString());
    }
}