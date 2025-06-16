/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fbd.contosmachadodeassis.main;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author zorte
 */
public class WikiScrapperTest {

    @Test
    public void testGetAmountOfAsterisk() {
        assertEquals(0, WikiScrapper.getAmountOfAsterisk("Sem asterisco"));
        assertEquals(1, WikiScrapper.getAmountOfAsterisk("Um * asterisco"));
        assertEquals(2, WikiScrapper.getAmountOfAsterisk("*Dois*"));
        assertEquals(3, WikiScrapper.getAmountOfAsterisk("***"));
        assertEquals(4, WikiScrapper.getAmountOfAsterisk("**** Algo"));
        assertEquals(0, WikiScrapper.getAmountOfAsterisk(""));
    }

    @Test
    public void testGetClassificacaoPadrao() {
        String input = "Conto normal";
        String esperado = Classificacao.PADRAO;
        assertEquals(esperado, WikiScrapper.getClassificacao(input));
    }

    @Test
    public void testGetClassificacaoReescrito() {
        String input = "*Conto reescrito";
        String esperado = Classificacao.REESCRITO;
        assertEquals(esperado, WikiScrapper.getClassificacao(input));
    }

    @Test
    public void testGetClassificacaoQuestionavel() {
        String input = "*Conto* questionável";
        String esperado = Classificacao.QUESTIONAVEL;
        assertEquals(esperado, WikiScrapper.getClassificacao(input));
    }

    @Test
    public void testGetClassificacaoExperimental() {
        String input = "*** Conto experimental";
        String esperado = Classificacao.EXPERIMENTAL;
        assertEquals(esperado, WikiScrapper.getClassificacao(input));
    }

    @Test
    public void testGetClassificacaoNovela() {
        String input = "**** Conto com traços de novela";
        String esperado = Classificacao.NOVELA;
        assertEquals(esperado, WikiScrapper.getClassificacao(input));
    }

    @Test
    public void testRemoveAsteriscoEAspasDuplas() {
        String entrada = "*Um conto* \"especial\"";
        String esperado = "Um conto especial";
        String resultado = WikiScrapper.getTitleWithoutEspecialChars(entrada);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testRemoveAspasTipograficas() {
        String entrada = "Título com *caracteres* especiais";
        String esperado = "Título com caracteres especiais";
        String resultado = WikiScrapper.getTitleWithoutEspecialChars(entrada);
        assertEquals(esperado, resultado);
    }

}
