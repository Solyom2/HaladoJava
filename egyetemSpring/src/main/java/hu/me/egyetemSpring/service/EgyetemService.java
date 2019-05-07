package hu.me.egyetemSpring.service;

import hu.me.egyetemSpring.model.Egyetem;
import hu.me.egyetemSpring.model.Hallgato;
import hu.me.egyetemSpring.model.InputJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EgyetemService {

    private EgyetemRepository egyetemRepository;
    private HallgatoRepository hallgatoRepository;

    @Autowired
    public void setEgyetemRepository(EgyetemRepository egyetemRepository) {
        this.egyetemRepository = egyetemRepository;
    }

    @Autowired
    public void setHallgatoRepository(HallgatoRepository hallgatoRepository) {
        this.hallgatoRepository = hallgatoRepository;
    }

    public void addAdat(InputJSON inputJSON) {
        Hallgato hallgato = new Hallgato(inputJSON.getHallgatoNev(), inputJSON.getHallgatoSzak());
        Egyetem egyetem = new Egyetem(inputJSON.getEgyetemNev(), inputJSON.getEgyetemVaros());

        boolean egyetemExists = checkEgyetem(egyetem);
        boolean hallgatoExists = checkHallgato(hallgato);

        if(egyetemExists && hallgatoExists) {
            System.out.println("Mindkettő bent van");
            return;
        }
        else if(egyetemExists && !hallgatoExists) {
            System.out.println("Egyetem létezik");
            saveHallgato(hallgato, egyetem);
        }
        else if(!egyetemExists && hallgatoExists) {
            System.out.println("hallgató létezik");
            saveEgyetem(hallgato, egyetem);
        }
        else {
            Set<Egyetem> egyetemek = new HashSet<>();
            Set<Hallgato> hallgatok = new HashSet<>();
            egyetemek.add(egyetem);
            hallgatok.add(hallgato);

            egyetem.setHallgatok(hallgatok);
            hallgato.setEgyetemek(egyetemek);

            hallgatoRepository.save(hallgato);
            egyetemRepository.save(egyetem);
        }


    }

    public void saveHallgato(Hallgato hallgato, Egyetem egyetem) {
        Set<Egyetem> result = egyetemRepository.findByNevAndVarosIn(egyetem.getNev(), egyetem.getVaros());

        hallgato.setEgyetemek(result);
        hallgatoRepository.save(hallgato);

        System.out.println(hallgatoRepository.findAll().toString());
    }

    public void saveEgyetem(Hallgato hallgato, Egyetem egyetem) {
        Set<Hallgato> result = hallgatoRepository.findByNevAndSzakIn(hallgato.getNev(), hallgato.getSzak());

        egyetem.setHallgatok(result);
        egyetemRepository.save(egyetem);

        System.out.println(egyetemRepository.findAll().toString());
    }

    public boolean checkHallgato(Hallgato hallgato) {
        Iterable<Hallgato> results = hallgatoRepository.findAll();

        for(Hallgato h : results) {
            if(h.getNev().equals(hallgato.getNev()) && h.getSzak().equals(hallgato.getSzak())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEgyetem(Egyetem egyetem) {
        Iterable<Egyetem> results = egyetemRepository.findAll();

        for(Egyetem e : results) {
            if(e.getNev().equals(egyetem.getNev()) && e.getVaros().equals(egyetem.getVaros())) {
                return true;
            }
        }
        return false;
    }

}
