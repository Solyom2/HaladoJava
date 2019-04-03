package hu.me.webcalculator.model;

public class Log {

    private Input input;
    private double eredmeny;

    public Log(Input input, double eredmeny) {
        this.input = input;
        this.eredmeny = eredmeny;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
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
                "input=" + input +
                ", eredmeny=" + eredmeny +
                '}';
    }
}
