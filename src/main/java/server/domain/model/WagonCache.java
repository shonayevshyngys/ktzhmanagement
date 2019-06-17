package server.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "wagon_cache")
public class WagonCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "wagonCacheId", optional = false)
    @JoinColumn(name = "vagon_id")
    private VagonInfo vagon_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId")
    private List<Position> positions;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId",optional = false)
    @JoinColumn(name = "user_wagon_id")
    private UserWagon userWagonId;

    public WagonCache() {
    }
}
