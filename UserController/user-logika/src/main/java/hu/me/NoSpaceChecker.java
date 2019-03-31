package hu.me;

public class NoSpaceChecker implements DataChecker {

    public ValidatorResponse valid(User user) {
        if(user.getUserName().contains(" ") || user.getPassword().contains(" ")) {
            return new ValidatorResponse(false, "Szóközt tartalmazó felhasználónév vagy jelszó");
        }
        else {
            return new ValidatorResponse(true, "Nincs hiba");
        }
    }

}
