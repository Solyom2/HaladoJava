package hu.me;

public class Registration {

    private Repository repository = new Repository();

    public void mentes(User user) {
        repository.addUser(user);
    }


}
