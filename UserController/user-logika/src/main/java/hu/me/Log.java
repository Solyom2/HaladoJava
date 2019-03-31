package hu.me;

public class Log {

    private User user;
    private String message;

    public Log(User user, String error) {
        this.user = user;
        this.message = error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getError() {
        return message;
    }

    public void setError(String error) {
        this.message = error;
    }

    public void writeLog() {
        System.out.println(message + ":" + user.getUserName());
    }

}
