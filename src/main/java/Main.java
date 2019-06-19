import server.domain.dao.PositionDAO;
import server.domain.dao.UserDAO;
import server.domain.dao.WagonCacheDAO;
import server.domain.model.Position;
import server.domain.model.WagonCache;

public class Main {
    public static void main(String[] args) {
        // WagonCache wagonCache = new WagonCache(new);
        //WagonCacheDAO.persist(wagonCache);
//        UserDAO.persist(new User(new Date(), new Date(), "", "aman1", HashUtils.hashPassword("password"), "user"));
//        UserWagonDAO.persist(new UserWagon(UserDAO.getById(6),"aman", WagonCacheDAO.getById(1)));
    UserDAO.getAllUserWagonByUserId(6).forEach(wagons -> {
        System.out.println(wagons.getClientId());
    });
//        PositionDAO.getAllPositionsByUserWagonId(1).forEach(position -> System.out.println(position.toString()));
//        WagonCache wagonCache = WagonCacheDAO.getWagonCacheByUserWagonId(6);
//        wagonCache.getPositions().forEach(position -> System.out.println(position.getId()));
//        wagonCache.getRepairs().forEach(repair -> System.out.println(repair.getId()));
//        System.out.println(WagonCacheDAO.getById(1).getVagon_no());

    }
}
