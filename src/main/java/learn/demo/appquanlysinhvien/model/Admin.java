package learn.demo.appquanlysinhvien.model;

/**
 *
 * @author Ngô Duy Minh
 */
public class Admin {
    private String username, password;

    public Admin() {
    }

    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
