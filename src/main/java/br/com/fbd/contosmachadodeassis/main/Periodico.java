package br.com.fbd.contosmachadodeassis.main;

public class Periodico {
    private int id;
    private String nome;

    @Override
    public String toString() {
        return "Periodico [id = " + id + ", nome = " + nome;
    }

    public Periodico(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

/*CREATE TABLE `periodico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)*/