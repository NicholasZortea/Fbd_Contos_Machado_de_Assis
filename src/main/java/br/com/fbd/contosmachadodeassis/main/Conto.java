package br.com.fbd.contosmachadodeassis.main;

public class Conto {
    private int id;
    private String titulo;
    private java.sql.Date anoPublicacao;
    private int numPalavras;
    private int idColetanea;
    private int idPeriodico;
    private int idClassificacao;

    public Conto(int id, String titulo, java.sql.Date anoPublicacao, int numPalavras, int idColetanea, int idPeriodico, int idClassificacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.numPalavras = numPalavras;
        this.idColetanea = idColetanea;
        this.idPeriodico = idPeriodico;
        this.idClassificacao = idClassificacao;
    }

    @Override
    public String toString() {
        return "Conto [ID = " + id + ", Titulo = " + titulo + ", Ano de Publicacao = " + anoPublicacao + ", Numero de Palavras = " + numPalavras
                + " ID Coletanea = " + idColetanea + ", ID Periodico = " + idPeriodico + ", ID Classificacao = " + idClassificacao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAnoPublicacao(java.sql.Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public java.sql.Date getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setNumPalavras(int numPalavras) {
        this.numPalavras = numPalavras;
    }
    public int getNumPalavras() {
        return numPalavras;
    }
    public void setIdColetanea(int idColetanea) {
        this.idColetanea = idColetanea;
    }
    public int getIdColetanea() {
        return idColetanea;
    }
    public void setIdPeriodico(int idPeriodico) {
        this.idPeriodico = idPeriodico;
    }
    public int getIdPeriodico() {
        return idPeriodico;
    }
    public void setIdClassificacao(int idClassificacao) {
        this.idClassificacao = idClassificacao;
    }
    public int getIdClassificacao() {
        return idClassificacao;
    }
}

/*CREATE TABLE `conto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `ano_publicacao` date NOT NULL,
  `nmr_palavras` int NOT NULL,
  `idColetanea` int NOT NULL,
  `idPeriodico` int NOT NULL,
  `idClassificacao` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idClassificacao` (`idClassificacao`),
  KEY `idPeriodico` (`idPeriodico`),
  KEY `idColetanea` (`idColetanea`),
  CONSTRAINT `conto_ibfk_1` FOREIGN KEY (`idClassificacao`) REFERENCES `classificacao` (`id`),
  CONSTRAINT `conto_ibfk_2` FOREIGN KEY (`idPeriodico`) REFERENCES `periodico` (`id`),
  CONSTRAINT `conto_ibfk_3` FOREIGN KEY (`idColetanea`) REFERENCES `coletanea` (`id`)*/