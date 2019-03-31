package hu.me;

public class LengthChecker implements DataChecker {

    public ValidatorResponse valid(User user) {
        if(user.getUserName().length() < 6 || user.getPassword().length() < 6) {
            return new ValidatorResponse(false, "Túl rövid felhasználónév vagy jelszó");
        }
        else {
            return new ValidatorResponse(true, "Nincs hiba");
        }
    }

}
