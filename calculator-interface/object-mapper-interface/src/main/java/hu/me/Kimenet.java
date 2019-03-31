package hu.me;

public class Kimenet {

    private double eredmeny;
    private String uzenet;
    private Hibakod hibakod;

    public Kimenet() {
        this.eredmeny = 0;
        this.uzenet = "nincs";
        this.hibakod = Hibakod.NINCS;
    }

    public double getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(double eredmeny) {
        this.eredmeny = eredmeny;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    public Hibakod getHibakod() {
        return hibakod;
    }

    public void setHibakod(Hibakod hibakod) {
        this.hibakod = hibakod;
    }

    @Override
    public String toString() {
        return "Kimenet{" +
                "eredmeny=" + eredmeny +
                ", uzenet='" + uzenet + '\'' +
                ", hibakod=" + hibakod +
                '}';
    }
}
