package server.domain.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "user_wagons")
public class UserWagon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
        this.user = new User(LocalDate.now(), LocalDate.now(), "", user, "pass", "user");
        this.clientId = user;
        this.wagonCacheId = new WagonCache();
    }
}
