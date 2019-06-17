package server.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "wagon_cache")
public class WagonCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId")
    private List<Position> positions;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId", optional = false)
    @JoinColumn(name = "user_wagon_id")
    private UserWagon userWagonId;

    public WagonCache() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public UserWagon getUserWagonId() {
        return userWagonId;
    }

    public void setUserWagonId(UserWagon userWagonId) {
        this.userWagonId = userWagonId;
    }
}
