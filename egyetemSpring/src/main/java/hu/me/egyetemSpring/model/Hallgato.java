package hu.me.egyetemSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Hallgato {

    @Id
    @GeneratedValue
    private Long id;
    private String nev;
    private String szak;
    @ManyToMany(mappedBy = "hallgatok")
    private Set<Egyetem> egyetemek;

    public Hallgato() {}

    public Hallgato(String nev, String szak) {
        this.nev = nev;
        this.szak = szak;
    }

    public Hallgato(String nev, String szak, Set<Egyetem> egyetemek) {
        this.nev = nev;
        this.szak = szak;
        this.egyetemek = egyetemek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    public Set<Egyetem> getEgyetemek() {
        return egyetemek;
    }

    public void setEgyetemek(Set<Egyetem> egyetemek) {
        this.egyetemek = egyetemek;
    }


    @Override
    public String toString() {
        return "Hallgato{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", szak='" + szak + '\'' +
                ", egyetemek=" + egyetemek +
                '}';
    }
}
