/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import ohtuesimerkki.muut.Reader;
import ohtuesimerkki.muut.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saklindq
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats = new Statistics(readerStub);

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchPalauttaaPelaajanOikein() {
        assertEquals(new Player("Semenko", "EDM", 4, 12).toString(), stats.search("Sem").toString());
    }

    @Test
    public void searchPalauttaaNullinOikein() {
        assertEquals(null, stats.search("jee"));
    }

    @Test
    public void palauttaaTiiminOikein() {
        ArrayList<Player> edmPelaajat = new ArrayList<>();
        edmPelaajat.add(new Player("Semenko", "EDM", 4, 12));
        edmPelaajat.add(new Player("Kurri", "EDM", 37, 53));
        edmPelaajat.add(new Player("Gretzky", "EDM", 35, 89));
        
        assertEquals(edmPelaajat.toString(), stats.team("EDM").toString());
    }
    
    @Test
    public void palauttaaTiiminTyhjana() {
        ArrayList<Player> tyhjaLista = new ArrayList<>();
        assertEquals(tyhjaLista, stats.team("Turku"));
    }
    
    @Test
    public void palauttaaParhaanPelaajanOikein() {
        ArrayList<Player> paras = new ArrayList<>();
        paras.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(paras.toString(), stats.topScorers(0).toString());
    }
    
    @Test
    public void palauttaa3ParastaOikein() {
        ArrayList<Player> parhaat3 = new ArrayList<>();
        parhaat3.add(new Player("Gretzky", "EDM", 35, 89));
        parhaat3.add(new Player("Lemieux", "PIT", 45, 54));
        parhaat3.add(new Player("Yzerman", "DET", 42, 56));
        
        assertEquals(parhaat3.toString(), stats.topScorers(2).toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
