package hu.me;

public class Szamologep implements SzamologepInterface{

    public Szamologep() {}

    public double osszeadas(double a, double b) {
        return a+b;
    }

    public double kivonas(double a, double b) {
        return a-b;
    }

    public double szorzas(double a, double b) {
        return a*b;
    }

    public double osztas(double a, double b) {
        return a/b;
    }

}
