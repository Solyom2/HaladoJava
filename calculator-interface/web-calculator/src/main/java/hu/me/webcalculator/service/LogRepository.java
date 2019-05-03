package hu.me.webcalculator.service;

import hu.me.webcalculator.model.Log;
import hu.me.webcalculator.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {

    List<Log> findByOperator(String operator);
    List<Log> findByEredmeny(double eredmeny);
    List<Log> findByUser(User user);

}
