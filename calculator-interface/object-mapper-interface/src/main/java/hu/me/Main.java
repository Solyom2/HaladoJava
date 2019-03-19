package hu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    JSONMapperInterface jsonMapper;
    YAMLMapperInterface yamlMapper;

    @Autowired
    public void setJsonMapper(JSONMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Autowired
    public void setYamlMapper(YAMLMapper yamlMapper) {
        this.yamlMapper = yamlMapper;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        do{
            System.out.println("Válassz működést! 1. Konzol  2. JSON fájl 3. YAML fájl  4. Kilépés: ");
            int funkcio = scanner.nextInt();

            if(funkcio == 1) {
                jsonMapper.calculateByConsole();
            }
            if(funkcio == 2) {
                jsonMapper.calculateByJSON();
            }
            if(funkcio == 3) {
                yamlMapper.calculateByYAML();
            }
            if(funkcio == 4) {
                running = false;
            }
        }while (running);
    }

}