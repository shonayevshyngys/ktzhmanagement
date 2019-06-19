package server.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "user_wagons")
public class UserWagon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "client_id")
    private String clientId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wagon_cahce_id")
    private WagonCache wagonCacheId;


    public UserWagon() {
    }

    public UserWagon(User user, String clientId, WagonCache wagonCacheId) {
        this.user = user;
        this.clientId = clientId;
        this.wagonCacheId = wagonCacheId;
    }
    public UserWagon(String user) {
        this.user = new User(new Date(),new Date(), "", user, "pass", "user");
        this.clientId = user;
        this.wagonCacheId = new WagonCache();
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public WagonCache getWagonCacheId() {
        return wagonCacheId;
    }

    public void setWagonCacheId(WagonCache wagonCacheId) {
        this.wagonCacheId = wagonCacheId;
    }
}
