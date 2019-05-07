package hu.me.egyetemSpring.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Egyetem {

    @Id
    @GeneratedValue
    private Long id;
    private String nev;
    private String varos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hallgato_egyetem",
            joinColumns = @JoinColumn(name = "egyetem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hallgato_id", referencedColumnName = "id"))
    private Set<Hallgato> hallgatok;

    public Egyetem() {}

    public Egyetem(String nev, String varos) {
        this.nev = nev;
        this.varos = varos;
    }

    public Egyetem(String nev, String varos, Set<Hallgato> hallgatok) {
        this.nev = nev;
        this.varos = varos;
        this.hallgatok = hallgatok;
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

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public Set<Hallgato> getHallgatok() {
        return hallgatok;
    }

    public void setHallgatok(Set<Hallgato> hallgatok) {
        this.hallgatok = hallgatok;
    }


    @Override
    public String toString() {
        return "Egyetem{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", varos='" + varos;
    }
}
