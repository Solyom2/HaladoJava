package hu.me;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KeresFeldolgozoTest {

    @Test
    public void calculate_WhenEmptyBemenet_thenGiveErrorCode() {
        Bemenet bemenet = null;

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getHibakod(), is(Hibakod.URES_BEMENET));
    }

    @Test
    public void calculate_whenEmptyOperation_thenGiveErrorCode() {
        Bemenet bemenet = new Bemenet();
        double[] operandusok = {2, 3};
        bemenet.setOperandusok(operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getHibakod(), is(Hibakod.URES_BEMENET));
    }

    @Test
    public void calculate_whenInvalidOperation_thenGiveErrorCode() {
        double[] operandusok = {2, 3};
        Bemenet bemenet = new Bemenet("hatvanyozas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getHibakod(), is(Hibakod.HIBAS_MUVELETIJEL));
    }

    @Test
    public void calculate_whenInvalidOperands_thenGiveErrorCode() {
        double[] operandusok = {2};
        Bemenet bemenet = new Bemenet("szorzas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getHibakod(), is(Hibakod.HIBAS_OPERANDUS));
    }

    @Test
    public void calculate_whenDivideZero_thenGiveErrorCode() {
        double[] operandusok = {2, 0};
        Bemenet bemenet = new Bemenet("osztas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getHibakod(), is(Hibakod.NULLA_OSZTAS));
    }

    @Test
    public void calculate_whenOsszeadas_thenGiveResult() {
        double[] operandusok = {2, 3};
        Bemenet bemenet = new Bemenet("osszeadas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        Mockito.when(szamologep.osszeadas(2,3)).thenReturn(5.0);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getEredmeny(), Matchers.is(5.0));
        Mockito.verify(szamologep).osszeadas(2, 3);
    }

    @Test
    public void calculate_whenKivonas_thenGiveResult() {
        double[] operandusok = {2, 3};
        Bemenet bemenet = new Bemenet("kivonas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        Mockito.when(szamologep.kivonas(2,3)).thenReturn(-1.0);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getEredmeny(), Matchers.is(-1.0));
        Mockito.verify(szamologep).kivonas(2, 3);
    }

    @Test
    public void calculate_whenSzorzas_thenGiveResult() {
        double[] operandusok = {2, 3};
        Bemenet bemenet = new Bemenet("szorzas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        Mockito.when(szamologep.szorzas(2,3)).thenReturn(6.0);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getEredmeny(), Matchers.is(6.0));
        Mockito.verify(szamologep).szorzas(2, 3);
    }

    @Test
    public void calculate_whenOsztas_thenGiveResult() {
        double[] operandusok = {2, 3};
        Bemenet bemenet = new Bemenet("osztas", operandusok);

        Szamologep szamologep = Mockito.mock(Szamologep.class);
        Mockito.when(szamologep.osztas(2,3)).thenReturn(1.5);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

        Kimenet kimenet = keresFeldolgozo.calculate(bemenet);
        assertThat(kimenet.getEredmeny(), Matchers.is(1.5));
        Mockito.verify(szamologep).osztas(2, 3);
    }

    /*
    @Test
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
