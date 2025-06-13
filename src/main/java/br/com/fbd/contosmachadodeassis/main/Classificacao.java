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
        return "Coletanea [ID = " + id + ", Tipo = " + tipo;
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

/*CREATE TABLE `classificacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;*/