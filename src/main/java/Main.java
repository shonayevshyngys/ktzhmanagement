import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.UniversalDAO;
import server.domain.dao.UserActionsDAO;
import server.domain.dao.UserDAO;
import server.domain.dao.WagonCacheDAO;
import server.domain.model.User;
import server.domain.model.UserAction;
import server.domain.model.UserWagon;
import server.domain.model.WagonCache;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WagonCache wagonCache = new WagonCache(new);
        WagonCacheDAO.persist(wagonCache);

        //UserWagon userWagon = new UserWagon(UserDAO.getById(1),"Aman", WagonCacheDAO.getById());

    }
}
