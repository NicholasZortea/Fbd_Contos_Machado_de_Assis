package br.com.fbd.contosmachadodeassis.main;

import br.com.fbd.contosmachadodeassis.interfaces.ColetaneaDAO;
import br.com.fbd.contosmachadodeassis.interfaces.PeriodicoDAO;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiScrapper {

    public static String CONTOS_URL = "https://pt.wikipedia.org/wiki/Obra_de_Machado_de_Assis";
    public static int TITULO_CONTO_INDEX = 0;
    public static int DATA_CONTO_INDEX = 1;
    public static int PERIODICO_INDEX = 2;
    public static int COLETANEA_INDEX = 3;
    public static int NMR_PALAVRAS_INDEX = 4;


    public ArrayList<Conto> scrapWiki() throws IOException {
        Elements linhas = getLinesFromTable();
        for (Element linha : linhas) {
            if (ehLegenda(linha)) {
                // pula ou faz algo específico com a linha de legenda
                System.out.println("[Linha de legenda ignorada]");
                break;
            }
            Conto contoFromLine = createContoFromLine(linha);
        }
        return null;
    }

    private Elements getLinesFromTable() throws IOException {
        Document doc = Jsoup.connect(CONTOS_URL).get();
        Elements tabelas = doc.select("table:has(caption:matchesOwn(Lista de contos))");
        Element tabela = tabelas.first(); // pega a primeira encontrada
        Elements linhas = tabela.select("tbody tr");
        return linhas;
    }

    private boolean ehLegenda(Element linha) {
        return linha.select("th:matchesOwn((?i)\\s*Legenda\\s*)").size() > 0;
    }

    private Conto createContoFromLine(Element linha) {
        Conto c = new Conto();
        Elements colunas = linha.select("td");
        Periodico periodico = PeriodicoDAO.findOrCreate(colunas.get(PERIODICO_INDEX).text());
        Coletanea coletanea = ColetaneaDAO.findOrCreate(colunas.get(COLETANEA_INDEX).text());
        String nome = colunas.get(TITULO_CONTO_INDEX).text();
        String classificacao = getClassificacao(nome);
        System.out.println();
        return c;
    }

    public static String getClassificacao(String nome){
        if(!nome.contains("*")){
            return Classificacao.PADRAO;
        }
        return Classificacao.getClassificacaoBasedOnAsterisksAmount(getAmountOfAsterisk(nome));
    }

    public static int getAmountOfAsterisk(String nome){
        int cont = 0;
        for (int i = 0; i < nome.length(); i++){
            if(nome.charAt(i) == '*'){
                cont++;
            }
        }
        return cont;
    }

public static String getTitleWithoutEspecialChars(String nome) {
    if (nome == null) return null;
    return nome.replaceAll("[*\"]", "");
}

}
