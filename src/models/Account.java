package models;

public class Account {

    // we use for login
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Account [username=" + username + "]";
    }

    
}
