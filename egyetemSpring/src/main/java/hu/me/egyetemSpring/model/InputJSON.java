package hu.me.egyetemSpring.model;

public class InputJSON {

    private String hallgatoNev;
    private String hallgatoSzak;
    private String egyetemNev;
    private String egyetemVaros;

    //{"hallgatonev":"Kis Nagy Béla", "hallgatoszak":"informatikus","egyetemnev":"Miskolci egyetem","egyetemvaros":"Miskolc"}

    public InputJSON() {}

    public String getHallgatoNev() {
        return hallgatoNev;
    }

    public void setHallgatoNev(String hallgatoNev) {
        this.hallgatoNev = hallgatoNev;
    }

    public String getHallgatoSzak() {
        return hallgatoSzak;
    }

    public void setHallgatoSzak(String hallgatoSzak) {
        this.hallgatoSzak = hallgatoSzak;
    }

    public String getEgyetemNev() {
        return egyetemNev;
    }

    public void setEgyetemNev(String egyetemNev) {
        this.egyetemNev = egyetemNev;
    }

    public String getEgyetemVaros() {
        return egyetemVaros;
    }

    public void setEgyetemVaros(String egyetemVaros) {
        this.egyetemVaros = egyetemVaros;
    }
}
