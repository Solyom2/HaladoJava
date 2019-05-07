package hu.me.egyetemSpring.service;

import hu.me.egyetemSpring.model.Egyetem;
import hu.me.egyetemSpring.model.Hallgato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HallgatoRepository extends CrudRepository<Hallgato, Long> {

    Set<Hallgato> findByNevAndSzakIn(String nev, String szak);

}
