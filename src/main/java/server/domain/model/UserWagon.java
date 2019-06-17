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

    @Column(name = "client_id")
    private String clientId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wagon_cahce_id")
    private WagonCache wagonCacheId;


}
