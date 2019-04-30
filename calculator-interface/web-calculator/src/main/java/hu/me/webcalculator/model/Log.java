package hu.me.webcalculator.model;

import hu.me.webcalculator.model.Input;

import javax.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue
    private Long id;

    private double a;
    private double b;
    private String operator;
    private double eredmeny;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Log() {}

    public Log(double a, double b, String operator, double eredmeny) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.eredmeny = eredmeny;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(double eredmeny) {
        this.eredmeny = eredmeny;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", operator='" + operator + '\'' +
                ", eredmeny=" + eredmeny +
                '}';
    }
}
