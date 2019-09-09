package buscagoogle;

import cadastros.Filmes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BuscaFilmesGoogle {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com.br");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void buscaFilmes(ArrayList<Filmes> filmesArrayList) {
        if (filmesArrayList.size() == 0 ){
           System.out.println("Não existem filmes para serem pesquisados!");
        }
        WebElement campoBusca = driver.findElement(By.name("q"));

        for (int i = 0; i < filmesArrayList.size(); i++) {
            Filmes fil = filmesArrayList.get(i);
            campoBusca.sendKeys("Filme " + fil.getNomeFilme() + " Lançamento " +  fil.getAnoLancamento() + " Diretor " + fil.getNomeDiretor());
            campoBusca.sendKeys(Keys.RETURN);
        }

        System.out.println("\nFim da Busca\n");

        assertEquals("Google", driver.getTitle());
    }
}