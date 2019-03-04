package hu.me;

import hu.me.exceptions.InvalidNumberPlate;

public class Auto {

    private String rendszam;
    private String marka;
    private String szin;
    private int dij;
    private boolean kolcsonozve;

    public Auto(String rendszam, String marka, String szin, int dij) throws InvalidNumberPlate {
        if(!rendszam.matches("[A-Z]{3}-[0-9]{3}")) throw new  InvalidNumberPlate("Hibás rendszám");

        this.rendszam = rendszam;
        this.marka = marka;
        this.szin = szin;
        this.dij = dij;
        this.kolcsonozve = false;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws InvalidNumberPlate {
        if(!rendszam.matches("[A-Z]3-[0-9]3")) throw new  InvalidNumberPlate("Hibás rendszám");
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public int getDij() {
        return dij;
    }

    public void setDij(int dij) {
        this.dij = dij;
    }

    public boolean isKolcsonozve() {
        return kolcsonozve;
    }

    public void setKolcsonozve(boolean kolcsonozve) {
        this.kolcsonozve = kolcsonozve;
    }
}
