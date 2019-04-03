package hu.me.webcalculator.service.impl;

import hu.me.Szamologep;
import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.model.Log;
import hu.me.webcalculator.service.CalculatorServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Service
public class CalculatorService implements CalculatorServiceInterface{

    private Szamologep szamologep = new Szamologep();
    private ArrayList<Log> logs = new ArrayList<>();

    public ArrayList<Log> getLogs() {
        return logs;
    }

    @Override
    public double calculate(Input input) {
        double eredmeny = 0;

        switch(input.getOperator()) {
            case ("+"): eredmeny = szamologep.osszeadas(input.getA(), input.getB()); log(input, eredmeny); // szamologep muvelttel van baj
            break;
            case ("-"): eredmeny = szamologep.kivonas(input.getA(), input.getB()); log(input, eredmeny);
            break;
            case ("*"): eredmeny = szamologep.szorzas(input.getA(), input.getB()); log(input, eredmeny);
            break;
            case ("/"): eredmeny = szamologep.osztas(input.getA(), input.getB()); log(input, eredmeny);
            break;
        }
        return eredmeny;
    }

    @Override
    public void log(Input input, double eredmeny) {
        logs.add(new Log(input, eredmeny));
        System.out.println(logs.toString());
    }



}
