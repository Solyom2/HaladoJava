package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class YAMLMapper implements YAMLMapperInterface{

    private  Szamologep szamologep = new Szamologep();
    private KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(szamologep);

    public void calculateByYAML() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            Bemenet bemenet = objectMapper.readValue(new File("bemenet.yaml"), Bemenet.class);
            Kimenet kimenet;

            kimenet = keresFeldolgozo.calculate(bemenet);
            writeYAML(kimenet);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeYAML(Kimenet kimenet) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            FileOutputStream fos = new FileOutputStream("kimenet.yaml");
            SequenceWriter sw = objectMapper.writerWithDefaultPrettyPrinter().writeValues(fos);
            sw.write(kimenet);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
