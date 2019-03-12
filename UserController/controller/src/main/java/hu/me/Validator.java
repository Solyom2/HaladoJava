package hu.me;

import java.util.ArrayList;

public class Validator {

    private ArrayList<Log> hibak = new ArrayList<>();

    public boolean makeChecks(User user, ArrayList<DataChecker> checkers) {
        boolean valid = true;

        for(DataChecker checker : checkers) {
            valid = checker.valid(user);

            if(!valid) {
                if(checker.getClass().getName().equals("LengthChecker")) {
                    Log log = new Log(user, "Túl rövid felhasználónév vagy jelszó");
                    hibak.add(log);
                }
                else if(checker.getClass().getName().equals("NoSpaceChecker")) {
                    Log log = new Log(user, "Szóközt tartalmaz");
                    hibak.add(log);
                }
            }
        }
        return valid;
    }

}
