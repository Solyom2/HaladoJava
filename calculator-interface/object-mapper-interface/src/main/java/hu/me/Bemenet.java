package hu.me;

import java.util.Arrays;

public class Bemenet {

    private String muvelet;
    private int[] operandusok;

    public String getMuvelet() {
        return muvelet;
    }

    public void setMuvelet(String muvelet) {
        this.muvelet = muvelet;
    }

    public int[] getOperandusok() {
        return operandusok;
    }

    public void setOperandusok(int[] operandusok) {
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
