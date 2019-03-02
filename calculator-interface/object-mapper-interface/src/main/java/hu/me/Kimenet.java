package hu.me;

public class Kimenet {

    private int eredmeny;
    private String uzenet;
    private int hibakod;

    public Kimenet() {
        this.eredmeny = 0;
        this.uzenet = "nincs";
        this.hibakod = 0;
    }

    public void setEredmeny(int eredmeny) {
        this.eredmeny = eredmeny;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    public void setHibakod(int hibakod) {
        this.hibakod = hibakod;
    }

    public int getEredmeny() {
        return eredmeny;
    }

    public String getUzenet() {
        return uzenet;
    }

    public int getHibakod() {
        return hibakod;
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
