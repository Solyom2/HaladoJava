package hu.me;

import hu.me.exceptions.InvalidNumberPlate;

public class Kolcsonzes {

    private Auto auto;
    private String kolcsonzo;
    private int ido;

    public Kolcsonzes(Auto auto, String kolcsonzo, int ido) {
        this.auto = auto;
        this.kolcsonzo = kolcsonzo;
        this.ido = ido;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getKolcsonzo() {
        return kolcsonzo;
    }

    public void setKolcsonzo(String kolcsonzo) {
        this.kolcsonzo = kolcsonzo;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

}
