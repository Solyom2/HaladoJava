package hu.me;

public class KeresFeldolgozo {

    private Szamologep szamologep;

    public KeresFeldolgozo(Szamologep szamologep) {
        this.szamologep = szamologep;
    }

    public Kimenet calculate(Bemenet bemenet) {
        Kimenet kimenet = new Kimenet();

        try {
            if(bemenet == null || bemenet.getMuvelet() == null) {
                kimenet.setHibakod(Hibakod.URES_BEMENET);
                return kimenet;
            }

            else if(bemenet.getOperandusok().length == 0 || bemenet.getOperandusok().length == 1) {
                kimenet.setHibakod(Hibakod.HIBAS_OPERANDUS);
                return kimenet;
            }

            else if(!bemenet.getMuvelet().equals("osszeadas") && !bemenet.getMuvelet().equals("kivonas") && !bemenet.getMuvelet().equals("szorzas") && !bemenet.getMuvelet().equals("osztas")) {
                    kimenet.setHibakod(Hibakod.HIBAS_MUVELETIJEL);
                    return kimenet;
            }

            else if(bemenet.getMuvelet().equals("osztas") && bemenet.getOperandus2() == 0) {
                kimenet.setHibakod(Hibakod.NULLA_OSZTAS);
                return kimenet;
            }

            double[] operandusok = bemenet.getOperandusok();
            double eredmeny = 0;

            if(bemenet.getMuvelet().equals("osszeadas")) {
                eredmeny = szamologep.osszeadas(operandusok[0], operandusok[1]);
            }
            else if(bemenet.getMuvelet().equals("kivonas")) {
                eredmeny = szamologep.kivonas(operandusok[0], operandusok[1]);
            }
            else if(bemenet.getMuvelet().equals("szorzas")) {
                eredmeny = szamologep.szorzas(operandusok[0], operandusok[1]);
            }
            else if(bemenet.getMuvelet().equals("osztas")) {
                eredmeny = szamologep.osztas(operandusok[0], operandusok[1]);
            }
            kimenet.setEredmeny(eredmeny);
        }catch (Exception e) {
            kimenet.setUzenet(e.getMessage());
        }

        return kimenet;
    }

    /*Szamologep2 szamologep;

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

    }*/
}
