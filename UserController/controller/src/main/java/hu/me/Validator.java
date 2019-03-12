package hu.me;

import java.util.ArrayList;

public class Validator {


    public boolean makeChecks(User user, ArrayList<DataChecker> checkers, ArrayList<ValidatorResponse> hibak) {

        ValidatorResponse valid;

        for(DataChecker checker : checkers) {
            valid = checker.valid(user);
            if(!valid.isValid()) {
                hibak.add(valid);
            }
        }

        System.out.println("A hibák száma: " + hibak.size());
        for(ValidatorResponse validatorResponse : hibak) {
            System.out.println(validatorResponse.getError());
        }

        if(hibak.size() > 0) {
            return false;
        }
        else return true;
    }

}
