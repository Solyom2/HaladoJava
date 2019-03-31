package hu.me.webcalculator.service;

import hu.me.webcalculator.model.Input;

import java.util.ArrayList;

public interface CalculatorServiceInterface {

    double calculate(Input input);
    void log(Input input, double eredmeny);

}
