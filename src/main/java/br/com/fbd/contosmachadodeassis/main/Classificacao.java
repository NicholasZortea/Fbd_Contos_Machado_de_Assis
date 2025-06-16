package br.com.fbd.contosmachadodeassis.main;

public class Classificacao {
    private int id;
    private String tipo;
    public static String QUESTIONAVEL = "autoria questionaval";
    public static String NOVELA = "conto com caracteristicas de novela";
    public static String PADRAO = "conto padrao";
    public static String EXPERIMENTAL = "experimental e dificil classificacao";
    public static String REESCRITO = "reescrito";

    public Classificacao(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Classificacao [ID = " + id + ", Tipo = " + tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

      public static String getClassificacaoBasedOnAsterisksAmount(int amountOfAsterisk) {
        String s = null;
        switch(amountOfAsterisk){
            case 1 -> s = REESCRITO;
            case 2 -> s = QUESTIONAVEL;
            case 3 -> s = EXPERIMENTAL;
            case 4 -> s = NOVELA;
        }
        return s;
    }
}