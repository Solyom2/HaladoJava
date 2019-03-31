package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Service
public class JSONMapper implements JSONMapperInterface{

    private  Szamologep szamologep = new Szamologep();
    private KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

    public void calculateByJSON() {

        try{
            byte[] jsonData = Files.readAllBytes(Paths.get("bemenet.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Bemenet bemenet = objectMapper.readValue(jsonData, Bemenet.class);
            Kimenet kimenet;

            kimenet = keresFeldolgozo.calculate(bemenet);
            writeJSON(kimenet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculateByConsole() {
        Scanner scanner = new Scanner(System.in);
        double[] operandusok = new double[2];
        String operacio;
        boolean wrong = true;

        System.out.println("Add meg az 1. operandust: ");
        operandusok[0] = scanner.nextInt();
        System.out.println("Add meg az 2. operandust: ");
        operandusok[1] = scanner.nextInt();
        do {
            System.out.println("Add meg az operációt: ");
            operacio = scanner.next();
            if(operacio.equals("osszeadas") ||  operacio.equals("kivonas") || operacio.equals("szorzas") || operacio.equals("osztas")) wrong = false;
        }while(wrong);

        Bemenet bemenet = new Bemenet(operacio, operandusok);
        Kimenet kimenet = new Kimenet();

        try {
            kimenet = keresFeldolgozo.calculate(bemenet);
            writeJSON(kimenet);
        }catch (Exception e) {
            kimenet.setUzenet(e.getMessage());
        }
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
