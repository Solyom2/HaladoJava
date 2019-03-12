package hu.me;

public class NoSpaceChecker implements DataChecker {

    public boolean valid(User user) {
        if(user.getUserName().contains(" ") || user.getPassword().contains(" ")) {
            return false;
        }
        else {
            return true;
        }
    }

}
