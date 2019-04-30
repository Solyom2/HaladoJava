package hu.me.webcalculator.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Input {

    private int id;
    private String nev;
    private int eletkor;

    @NotNull
    private int a;

    @NotNull
    private int b;

    @NotNull
    @NotEmpty
    private String operator;

    /*public Input(@NotNull int a, @NotNull int b, @NotNull @NotEmpty String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }*/

    public Input(int id, String nev, int eletkor, @NotNull int a, @NotNull int b, @NotNull @NotEmpty String operator) {
        this.id = id;
        this.nev = nev;
        this.eletkor = eletkor;
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Input{" +
                "a=" + a +
                ", b=" + b +
                ", operator='" + operator + '\'' +
                '}';
    }
}
