package hu.me.egyetemSpring.service;

import hu.me.egyetemSpring.model.Egyetem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface EgyetemRepository extends CrudRepository<Egyetem, Long> {

    Set<Egyetem> findByNevAndVarosIn(String nev, String varos);

}
