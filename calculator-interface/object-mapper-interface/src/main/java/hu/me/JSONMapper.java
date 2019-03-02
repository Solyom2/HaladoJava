package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JSONMapper {

    public void calculateByJSON() {

        try{
            byte[] jsonData = Files.readAllBytes(Paths.get("bemenet.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Bemenet bemenet = objectMapper.readValue(jsonData, Bemenet.class);

            Kimenet kimenet = new Kimenet();
            double eredmeny = 0;
            try {
                eredmeny = calculate(bemenet);
                kimenet.setEredmeny(eredmeny);
            }catch (Exception e) {
                kimenet.setHibakod(1);
                kimenet.setUzenet(e.getMessage());
            }
            writeJSON(kimenet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculateByConsole() {
        Scanner scanner = new Scanner(System.in);
        double a, b, eredmeny = 0;
        String operacio;
        boolean wrong = true;

        System.out.println("Add meg az 1. operandust: ");
        a = scanner.nextInt();
        System.out.println("Add meg az 2. operandust: ");
        b = scanner.nextInt();
        do {
            System.out.println("Add meg az operációt(+,-,*,/): ");
            operacio = scanner.next();
            if(operacio.equals("+") ||  operacio.equals("-") || operacio.equals("*") || operacio.equals("/")) wrong = false;
        }while(wrong);

        Kimenet kimenet = new Kimenet();
        Szamologep szamologep = new Szamologep();
        try {
            if(operacio.equals("+")) {
                eredmeny = szamologep.osszeadas(a, b);
            }
            else if(operacio.equals("-")) {
                eredmeny = szamologep.kivonas(a ,b);
            }
            else if(operacio.equals("*")) {
                eredmeny = szamologep.szorzas(a, b);
            }
            else if(operacio.equals("/")) {
                eredmeny = szamologep.osztas(a, b);
            }
            kimenet.setEredmeny(eredmeny);
        }catch (Exception e) {
            kimenet.setHibakod(1);
            kimenet.setUzenet(e.getMessage());
        }
        writeJSON(kimenet);
    }

    public double calculate(Bemenet bemenet) {
        double eredmeny = 0;
        double[] operandusok = bemenet.getOperandusok();
        Szamologep szamologep = new Szamologep();

        if(bemenet.getMuvelet().equals("osszeadas")) {
            eredmeny = szamologep.osszeadas(operandusok[0], operandusok[1]);
        }
        else if(bemenet.getMuvelet().equals("kivonas")) {
            eredmeny = szamologep.osszeadas(operandusok[0], operandusok[1]);
        }
        else if(bemenet.getMuvelet().equals("szorzas")) {
            eredmeny = szamologep.osszeadas(operandusok[0], operandusok[1]);
        }
        else if(bemenet.getMuvelet().equals("osztas")) {
            eredmeny = szamologep.osszeadas(operandusok[0], operandusok[1]);
        }
        return eredmeny;
    }

    public void writeJSON(Kimenet kimenet) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(kimenet.toString());
            objectMapper.writeValue(new File("kimenet.json"), kimenet);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
