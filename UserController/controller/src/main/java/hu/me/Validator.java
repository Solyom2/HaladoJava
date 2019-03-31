package hu.me;

import java.util.ArrayList;

public class Validator {

    public ArrayList<ValidatorResponse> makeChecks(User user, ArrayList<DataChecker> checkers, ArrayList<ValidatorResponse> hibak) {

        ValidatorResponse valid;

        //squash

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

        return hibak;
    }

}
