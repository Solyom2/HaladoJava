package hu.me;

public class LengthChecker implements DataChecker {

    public boolean valid(User user) {
        if(user.getUserName().length() < 6 || user.getPassword().length() < 6) {
            return false;
        }
        else {
            return true;
        }
    }

}
