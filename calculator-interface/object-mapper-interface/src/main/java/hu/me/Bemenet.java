package hu.me;

import java.util.Arrays;

public class Bemenet {

    private String muvelet;
    private double[] operandusok;

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

    @Override
    public String toString() {
        return "Bemenet{" +
                "muvelet='" + muvelet + '\'' +
                ", operandusok=" + Arrays.toString(operandusok) +
                '}';
    }
}
