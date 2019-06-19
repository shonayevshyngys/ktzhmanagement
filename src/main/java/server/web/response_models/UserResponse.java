package server.web.response_models;

import server.domain.model.User;
import server.domain.model.UserAction;

import java.util.Date;
import java.util.List;

public class UserResponse {
    private long id;
    private Date createdAt;
    private Date lastLoginTime;
    private String token;
    private String username;
    private String password;
    private String role;
    private List<UserAction> userActions;

    public UserResponse(long id, Date createdAt, Date lastLoginTime, String token, String username, String password, String role, List<UserAction> userActions) {
        this.id = id;
        this.createdAt = createdAt;
        this.lastLoginTime = lastLoginTime;
        this.token = token;
        this.username = username;
        this.password = password;
        this.role = role;
        this.userActions = userActions;
    }

    public UserResponse() {
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.createdAt = user.getCreatedAt();
        this.lastLoginTime = user.getLastLoginTime();
        this.token = user.getToken();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.userActions = user.getUserActionList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserAction> getUserActions() {
        return userActions;
    }

    public void setUserActions(List<UserAction> userActions) {
        this.userActions = userActions;
    }
}
