package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileOutputStream;

public class YAMLMapper {

    public void calculateByYAML() {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            Bemenet bemenet = objectMapper.readValue(new File("bemenet.yaml"), Bemenet.class);
            JSONMapper jsonMapper = new JSONMapper();
            Kimenet kimenet = new Kimenet();
            int eredmeny;
            try {
                eredmeny = jsonMapper.calculate(bemenet);
                kimenet.setEredmeny(eredmeny);
            }catch (Exception e) {
                kimenet.setHibakod(1);
                kimenet.setUzenet(e.getMessage());
            }
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
