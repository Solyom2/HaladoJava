package hu.me;

import java.util.Arrays;

public class Bemenet {

    private String muvelet;
    private double[] operandusok;

    public Bemenet() {}

    public Bemenet(String muvelet, double[] operandusok) {
        this.muvelet = muvelet;
        this.operandusok = operandusok;
    }

    public String getMuvelet() {
        return muvelet;
    }

    public void setMuvelet(String muvelet) {
        this.muvelet = muvelet;
    }

    public double[] getOperandusok() {
        return operandusok;
    }

    public void setOperandusok(double[] operandusok) {
        this.operandusok = operandusok;
    }

    public double getOperandus1() {
        return operandusok[0];
    }

    public double getOperandus2() {
        return operandusok[1];
    }

    @Override
    public String toString() {
        return "Bemenet{" +
                "muvelet='" + muvelet + '\'' +
                ", operandusok=" + Arrays.toString(operandusok) +
                '}';
    }
}
