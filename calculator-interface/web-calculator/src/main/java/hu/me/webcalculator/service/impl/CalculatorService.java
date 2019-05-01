package hu.me.webcalculator.service.impl;

import hu.me.Szamologep;
import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.model.Log;
import hu.me.webcalculator.model.User;
import hu.me.webcalculator.service.CalculatorServiceInterface;
import hu.me.webcalculator.service.LogRepository;
import hu.me.webcalculator.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService implements CalculatorServiceInterface{

    private Szamologep szamologep = new Szamologep();
    private ArrayList<Log> logs = new ArrayList<>();

    private LogRepository logRepository;
    private UserRepository userRepository;

    @Autowired
    public void setLogRepository(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    @Override
    public double calculate(Input input) {
        double eredmeny = 0;
        double a = input.getA();
        double b = input.getB();
        String operator = input.getOperator();

        Long id = input.getId();
        String nev = input.getNev();
        int eletkor = input.getEletkor();
        User user = new User(id, nev, eletkor);

        switch(operator) {
            case ("+"): eredmeny = szamologep.osszeadas(a,b); log(a, b, operator, eredmeny, user);
                break;
            case ("-"): eredmeny = szamologep.kivonas(a,b); log(a, b, operator, eredmeny, user);
                break;
            case ("*"): eredmeny = szamologep.szorzas(a,b); log(a, b, operator, eredmeny, user);
                break;
            case ("/"): eredmeny = szamologep.osztas(a,b); log(a, b, operator, eredmeny, user);
                break;
        }
        return eredmeny;
    }

    @Override
    public void log(double a, double b, String operator, double eredmeny, User user) {
        Log log = new Log(a, b, operator, eredmeny);
        log.setUser(user);
        logRepository.save(log);
    }

    /*public void saveUser(Long id, String nev, int eletkor) {
        User user = new User(id, nev, eletkor);
        System.out.println(user.toString());
        userRepository.save(user);
    }*/

    public Iterable<Log> findLogs() {
        return logRepository.findAll();
    }

    public List<Log> findByEredmeny(double eredmeny) {
        return logRepository.findByEredmeny(eredmeny);
    }

    public List<Log> findByOperator(String operator) {
        return logRepository.findByOperator(operator);
    }

}