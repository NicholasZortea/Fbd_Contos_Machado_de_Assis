package br.com.fbd.contosmachadodeassis.main;

public class Classificacao {
    private int id;
    private String tipo;

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
}