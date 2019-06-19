import server.domain.HibernateUtils;
import server.domain.dao.PositionDAO;
import server.domain.dao.UserDAO;
import server.domain.dao.UserWagonDAO;
import server.domain.dao.WagonCacheDAO;
import server.domain.model.Position;
import server.domain.model.Repair;
import server.domain.model.User;
import server.domain.model.WagonCache;
import server.web.Utils.HashUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        HibernateUtils.getSession().close();
        // WagonCache wagonCache = new WagonCache(new);
        //WagonCacheDAO.persist(wagonCache);
//        UserDAO.persist(new User(new Date(), new Date(), "", "aman16", HashUtils.hashPassword("password"), "user"));
//        UserWagonDAO.persist(new UserWagon(UserDAO.getById(6),"aman", WagonCacheDAO.getById(1)));
//    UserDAO.getAllUserWagonByUserId(6).forEach(wagons -> {
//        System.out.println(wagons.getClientId());
//    });
//        PositionDAO.getAllPositionsByUserWagonId(1).forEach(position -> System.out.println(position.toString()));
//        WagonCache wagonCache = WagonCacheDAO.getWagonCacheByUserWagonId(6);
//        wagonCache.getPositions().forEach(position -> System.out.println(position.getId()));
//        wagonCache.getRepairs().forEach(repair -> System.out.println(repair.getId()));
//        System.out.println(WagonCacheDAO.getById(1).getVagon_no());
//        System.out.println(UserWagonDAO.getByClientId("aman270710967").getId());
//        List<Position> positions = new ArrayList<>();
//        List<Repair> repairs = new ArrayList<>();
//        WagonCache cache = new  WagonCache(positions, UserWagonDAO.getByClientId("aman270710967"),
//                data.getVagon().get(0).getVagon_info(), repairs);
    }
}
