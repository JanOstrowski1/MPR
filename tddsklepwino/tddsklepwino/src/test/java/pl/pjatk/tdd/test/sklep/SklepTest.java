package pl.pjatk.tdd.test.sklep;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.pjatk.tdd.sklep.KartaKlienta;
import pl.pjatk.tdd.sklep.Sklep;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SklepTest {

    @Parameterized.Parameter (value = 0)
    public double kwotaZakupu;

    @Parameterized.Parameter (value = 1)
    public int oczekiwanaIloscKuponow;

    private KartaKlienta karta;

    @Parameterized.Parameters (name = "[{index}] Przy zakupie za kwotę {0} oczekiwana ilość kuponów powinna wynieść {1}")
    public static Collection<Object[]> dataProvider(){
        return Arrays.asList(new Object[][]{
                //TODO: Dokończ wypisanie przypadków brzegowych dla 80 zł i 120 zł
                {39.99, 0},
                {40.00, 1},
                {79.99,1},
                {80.00,2},
                {88.88,2},
                {119.99,2},
                {120.00,3}
        });
    }

    @Before
    public void setup(){
        karta = Sklep.wydajNowaKarte();
    }

    @Test
    public void klientPowinienDostacOdpowiedniaIloscKuponow(){
        Sklep.dokonajZakupu(karta, kwotaZakupu);
        assertEquals(oczekiwanaIloscKuponow, karta.pobierzIloscDostepnychKuponow());
    }
}
