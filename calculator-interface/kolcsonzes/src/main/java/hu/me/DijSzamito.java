package hu.me;

public class DijSzamito {

    public double dijszamitas(Kolcsonzes kolcsonzes) {
        int ora = kolcsonzes.getIdo();
        int dij = kolcsonzes.getAuto().getDij();

        return ora * dij;
    }

}
