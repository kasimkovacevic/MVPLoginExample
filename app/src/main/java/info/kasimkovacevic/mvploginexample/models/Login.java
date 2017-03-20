package info.kasimkovacevic.mvploginexample.models;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public class Login {

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
