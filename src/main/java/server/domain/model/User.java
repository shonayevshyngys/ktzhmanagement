package server.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    @Column(name = "token")
    private String token;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userId")
    private List<UserAction> userActionList;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserWagon> userWagons;

    public User() {

    }

    public User(Date createdAt, Date lastLoginTime, String token, String username, String password, String role) {
        this.createdAt = createdAt;
        this.lastLoginTime = lastLoginTime;
        this.token = token;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public List<UserWagon> getUserWagons() {
        return userWagons;
    }

    public void setUserWagons(List<UserWagon> userWagons) {
        this.userWagons = userWagons;
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

    public List<UserAction> getUserActionList() {
        return userActionList;
    }

    public void setUserActionList(List<UserAction> userActionList) {
        this.userActionList = userActionList;
    }
}
