import server.domain.dao.RepairDAO;
import server.domain.dao.UserDAO;
import server.domain.dao.WagonCacheDAO;
import server.domain.model.Repair;
import server.domain.model.User;
import server.web.Utils.HashUtils;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // WagonCache wagonCache = new WagonCache(new);
        //WagonCacheDAO.persist(wagonCache);
//        UserDAO.persist(new User(new Date(), new Date(), "", "aman1", HashUtils.hashPassword("password"), "user"));
        //UserWagon userWagon = new UserWagon(UserDAO.getById(1),"Aman", WagonCacheDAO.getById());
      /*  Position position = new Position(WagonCacheDAO.getById(1),new Date(),123,
                123,new Date(),"Almaty",123,132,
                123,25.5, 56.5,456,"asd",
                "asd",123,"asd","index",123,123,
                "from_name",123,123,258,963,
                "name",123,528,546,658,"state",
                "country_code",22.5,"loaded",526,5564,"daysEnd",
                456,852,65,"addi",new Date(),"nomer",564,
                987,"gruz_kaspiiski", 564,564,"gruz_R_name",
                "broken", new Date(),22.5,"from_st_name",52,
                546,654,879,"to_s_name",
                54665,5546,665,new Date());
        PositionDAO.persist(position);*/
       /* Repair repair = new Repair(528,654,"last_rep_rep_decs",
                566,666,"deport_start_decs","sdfghjk",
                699,951, "deport_end_dewsc","xzcvbnm,",
                852,"repair_call_road_name",556,2315,
                "repair_station_name",5642,5642,
                98465321,978645,
                "repair_end_st_name",9868514,9854153,
                96251478,56132156,"repair_call_datetime",
                "repair_start_datetime","repair_end_datetime",984556,64564687,
                65489760,4564562,65456153, WagonCacheDAO.getById(1));
        RepairDAO.persist(repair);*/
    /*    List<Repair> repairs = RepairDAO.getAllRepairs();
        List<Position> positions = PositionDAO.getAllPositions();
       WagonCacheDAO.persist(new WagonCache(positions, new UserWagon(), new Date(), "123123", "123",
                "Almaty", (long) 123, (long) 123, "Almaty", 28.4, 28.4,
                "Astana", (long) 123, (long) 123, (long) 123, 28.5, 24.5, 45.5,
                "5645640", new Date(), (long) 1233, (long) 123, (long) 123, new Date(), new Date(), "asd",
                (long) 123, "AlterApp", "asd", "asd", 123, 25.4,
                25.5, "sad", "asd", new Date(), new Date(), 123, 25.5,
                123, 123, "sad", 123, 123,
                "asd", 123, "asd", 546, 546,
                564, 564, 852, 852, 7.5,
                852, 87, 564, 52.4, 654, 25.4,
                564, 654, new Date(), "asd", 852, new Date(), new Date(),
                new Date(), new Date(), 564, new Date(), 564, new Date(), new Date(), repairs));*/
       User user = new User(new Date(),new Date(),"","ara", HashUtils.hashPassword("ara"), "admin");
        UserDAO.persist(user);

    }
}
