package br.com.fbd.contosmachadodeassis.main;

public class Coletanea {
    private int id;
    private String nome;


    public Coletanea(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Coletanea [ID = " + id + ", Nome = " + nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}



/*CREATE TABLE `coletanea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)*/