package server.web.request_models;

public class UpdateUser {
    String username;
    String password;

    public UpdateUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UpdateUser() {
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
