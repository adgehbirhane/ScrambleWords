package model;

public class Account {

    // we use for identification
    private String full_name;

    // we may need an email to comminicate incase of rewared or comptition
    private String email;  

    // we use for login
    private String username;

    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Account [full_name=" + full_name + ", email=" + email + ", username=" + username + "]";
    }

    
}
