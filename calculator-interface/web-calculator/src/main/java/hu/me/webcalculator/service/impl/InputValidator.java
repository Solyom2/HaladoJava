package hu.me.webcalculator.service.impl;

import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.model.Log;
import hu.me.webcalculator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
public class InputValidator implements Validator {

    private CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Input.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {
        ValidationUtils.rejectIfEmpty(err, "a", "A ures");
        ValidationUtils.rejectIfEmpty(err, "b", "B ures");
        ValidationUtils.rejectIfEmpty(err, "operator", "Operator ures");

        Input input = (Input) obj;

        User user = new User(input.getId(), input.getNev(), input.getEletkor());

        Iterable<Log> logs = calculatorService.findLogsByUser(user);
        for(Log log : logs) {
            if(input.getA() == log.getA() && input.getB() == log.getB() && input.getOperator().equals(log.getOperator())) {
                err.reject("Ezt a kalkulaciot mar elvegezte");
            }
        }
    }

}
