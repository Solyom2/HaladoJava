package hu.me.webcalculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String nev;
    private int eletkor;

    public User() {}

    public User(String nev, int eletkor) {
        this.nev = nev;
        this.eletkor = eletkor;
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

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", eletkor=" + eletkor +
                '}';
    }
}
