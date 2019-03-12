package hu.me;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KeresFeldolgozoTest {

    @Test
    public void feldolgoz_WhenEmptyInput_theGiveErrorString() {
        InputValues input = new InputValues();

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(new Szamologep2());


        OutputValues eredmeny = keresFeldolgozo.feldolgoz(input);

        assertThat(eredmeny.getHibakod(), is(Hibakod.URES_BEMENET));
    }

    /*@Test
    public void feldolgoz_WhenEmptyOperator_ThenGiveErrorString() {
        Szamologep2 szamologep = Mockito.mock(Szamologep2.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);
        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("");

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);
        assertThat(eredmeny.getHibakod(), is(Hibakod.HIBAS_MUVELETIJEL));
    }

    @Test
    public void feldolgoz_WhenEmptyOperandus_theGiveErrorString() {
        InputValues input = new InputValues();

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(new Szamologep2());

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(input);

        //Assert.assertThat(eredmeny, );
    }*/

}
