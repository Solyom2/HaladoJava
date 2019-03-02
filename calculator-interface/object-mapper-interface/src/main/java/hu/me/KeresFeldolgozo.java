package hu.me;

public class KeresFeldolgozo {

    Szamologep2 szamologep;

    public KeresFeldolgozo(Szamologep2 szamologep) {
        this.szamologep = szamologep;
    }

    OutputValues feldolgoz(InputValues input) {
        OutputValues output = new OutputValues();

        if(input.getOperandus1() == null || input.getOperandus2() == null) {
            output.setHibakod(Hibakod.URES_BEMENET);
        }

        else if(input != null && input.getMuvelet() != null && input.getMuvelet().isEmpty()) {
            output.setHibakod(Hibakod.HIBAS_MUVELETIJEL);
        }

        else if(input.getMuvelet().equals("+")) {
            this.szamologep.osszeadas(input.getOperandus1(), input.getOperandus2());
        }

        else if(input.getMuvelet().equals("-")) {
            this.szamologep.kivonas(input.getOperandus1(), input.getOperandus2());

        }

        return output;

    }

}
