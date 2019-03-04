package hu.me;

import hu.me.exceptions.SikertelenKolcsonzes;

public class AutoKolcsonzo {

    private DijSzamito dijSzamito;

    public AutoKolcsonzo(DijSzamito dijSzamito) {
        this.dijSzamito = dijSzamito;
    }

    public double kikolcsonzes(Auto auto, String kolcsonzo, int ido) throws SikertelenKolcsonzes {

        if(auto.isKolcsonozve()) {
            throw new SikertelenKolcsonzes("Már ki van kölcsönözve");
        }

        else if(kolcsonzo.isEmpty()) {
            throw new SikertelenKolcsonzes("Helytelen név");
        }

        else if(ido < 1) {
            throw new SikertelenKolcsonzes("Időtartam nem megfelelő");
        }

        auto.setKolcsonozve(true);
        Kolcsonzes kolcsonzes = new Kolcsonzes(auto, kolcsonzo, ido);

        double dij = dijSzamito.dijszamitas(kolcsonzes);
        return dij;
    }

}
