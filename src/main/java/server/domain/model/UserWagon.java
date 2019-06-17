package server.domain.model;


import javax.persistence.*;

@Entity(name = "user_wagons")
public class UserWagon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_wagon")
    private String userWagon;


    public UserWagon() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserWagon() {
        return userWagon;
    }

    public void setUserWagon(String userWagon) {
        this.userWagon = userWagon;
    }

    public UserWagon(User user, String userWagon) {
        this.user = user;
        this.userWagon = userWagon;
    }
}
