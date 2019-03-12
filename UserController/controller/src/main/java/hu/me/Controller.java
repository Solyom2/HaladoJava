package hu.me;

import java.util.ArrayList;

public class Controller {

    public void register(User user, ArrayList<DataChecker> checkers, Registration registration, Validator validator) {

        boolean valid;

        valid = validator.makeChecks(user, checkers);

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
