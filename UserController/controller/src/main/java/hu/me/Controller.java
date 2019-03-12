package hu.me;

import java.util.ArrayList;

public class Controller {

    public void register(User user, ArrayList<DataChecker> checkers, Registration registration, Validator validator, ArrayList<ValidatorResponse> hibak) {

        boolean valid;

        valid = validator.makeChecks(user, checkers, hibak);

        if(!valid) {
            Log log = new Log(user, "Invalid username");
            log.writeLog();
        }

        else {
            registration.mentes(user);
            Log log = new Log(user, "Elmentve");
            log.writeLog();
        }
    }

}
