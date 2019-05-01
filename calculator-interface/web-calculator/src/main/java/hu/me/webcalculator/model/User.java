package hu.me.webcalculator.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;
    private String nev;
    private int eletkor;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Log> logs;

    public User() {}

    public User(Long id, String nev, int eletkor) {
        this.id = id;
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

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", eletkor=" + eletkor +
                ", logs=" + logs +
                '}';
    }
}
