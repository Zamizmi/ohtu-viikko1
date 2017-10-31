package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    Varasto varasto6;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(100, 100);
        varasto3 = new Varasto(10, 100);
        varasto4 = new Varasto(100, -100);
        varasto5 = new Varasto(-100, -100);
        varasto6 = new Varasto(-100);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoNegatiivisenAlusaldonVaraston() {
        assertEquals(0, varasto4.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTurhanVaraston() {
        assertEquals(0, varasto5.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTurhanVaraston2() {
        assertEquals(0, varasto6.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoSaldollisenVaraston() {
        assertEquals(100, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoYlitaydenVaraston() {
        assertEquals(10, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldonTayteen() {
        varasto.lisaaVarastoon(1000);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenLisaysEiTeeMitaan() {
        varasto.lisaaVarastoon(-8);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenOttoEiTeeMitaan() {
        varasto.otaVarastosta(-8);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void otaYliVarastonSaldon() {
        double saatuMaara = varasto2.otaVarastosta(105);

        assertEquals(100, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
     @Test
    public void toStringToimii() {
        assertEquals("saldo = 100.0, vielä tilaa 0.0", varasto2.toString());
    }

}
