package hu.me;

import java.util.ArrayList;

public class Validator {

    public boolean makeChecks(User user, ArrayList<DataChecker> checkers) {
        boolean valid;

        for(DataChecker checker : checkers) {
            valid = checker.valid(user);
            if(!valid) {
                return false;
            }
        }
        return true;
    }

}
