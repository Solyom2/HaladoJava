package hu.me;

import java.util.ArrayList;

public class Repository {

    ArrayList<User> userRepo = new ArrayList<>();

    public void addUser(User user) {
        userRepo.add(user);
    }

}
