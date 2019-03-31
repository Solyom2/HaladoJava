package hu.me;

import hu.me.exceptions.InvalidNumberPlate;
import hu.me.exceptions.SikertelenKolcsonzes;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;

public class KolcsonzesTest {

    private AutoKolcsonzo autoKolcsonzo;

    @Test(expected = InvalidNumberPlate.class)
    public void createAutoWithInvalidNumberPlate_theGiveError() throws InvalidNumberPlate {
        Auto auto = new Auto("DE3-F", "Opel", "Piros", 4000);
    }

    @Test(expected = SikertelenKolcsonzes.class)
    public void rentUnavailableCar_thenGiveError() throws SikertelenKolcsonzes, InvalidNumberPlate {

        DijSzamito dijSzamito = Mockito.mock(DijSzamito.class);
        autoKolcsonzo = new AutoKolcsonzo(dijSzamito);

        Auto auto = new Auto("DEE-123", "Opel", "Piros", 4000);
        auto.setKolcsonozve(true);
        double eredmeny = autoKolcsonzo.kikolcsonzes(auto, "Szabó László", 3);
    }

    @Test(expected = SikertelenKolcsonzes.class)
    public void rentWithInvalidName_thenGiveError() throws SikertelenKolcsonzes, InvalidNumberPlate {

        DijSzamito dijSzamito = Mockito.mock(DijSzamito.class);
        autoKolcsonzo = new AutoKolcsonzo(dijSzamito);

        Auto auto = new Auto("DEE-123", "Opel", "Piros", 4000);
        double eredmeny = autoKolcsonzo.kikolcsonzes(auto, "", 3);
    }

    @Test(expected = SikertelenKolcsonzes.class)
    public void rentForInvalidHours_thenGiveError() throws SikertelenKolcsonzes, InvalidNumberPlate {

        DijSzamito dijSzamito = Mockito.mock(DijSzamito.class);
        autoKolcsonzo = new AutoKolcsonzo(dijSzamito);

        Auto auto = new Auto("DEE-123", "Opel", "Piros", 4000);
        double eredmeny = autoKolcsonzo.kikolcsonzes(auto, "Szabó László", 0);
    }

    @Test(expected = SikertelenKolcsonzes.class)
    public void rentTheCar_thenGiveTheFee() throws SikertelenKolcsonzes, InvalidNumberPlate {

        DijSzamito dijSzamito = Mockito.mock(DijSzamito.class);
        autoKolcsonzo = new AutoKolcsonzo(dijSzamito);

        Auto auto = new Auto("DEE-123", "Opel", "Piros", 4000);
        Mockito.when(autoKolcsonzo.kikolcsonzes(auto, "Szabó László", 2)).thenReturn(8000.0);

        double eredmeny = autoKolcsonzo.kikolcsonzes(auto, "Szabó László", 2);
        assertThat(eredmeny, Matchers.is(8000.0));
    }

}
