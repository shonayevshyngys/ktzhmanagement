package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import server.domain.HibernateUtils;
import server.domain.model.UserWagon;

import java.util.List;

public class UserWagonDAO {
    //todo add another methods
    public static void persist(UserWagon userWagon) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(userWagon);
        transaction.commit();
        session.close();
    }

    //TODO change update
    public static void update(UserWagon userWagon) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(userWagon);

        transaction.commit();
        session.close();
    }

    public static void delete(UserWagon userWagon) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userWagon);
        transaction.commit();
        session.close();
    }

    public static List<UserWagon> getAllRepairs() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<UserWagon> userWagons = (List<UserWagon>) session.createQuery("From server.domain.model.UserWagon").list();
        transaction.commit();
        session.close();
        return userWagons;
    }

    public static UserWagon getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        UserWagon userWagon = (UserWagon)
                session.createQuery("FROM user_wagons uw WHERE uw.id = :id")
                        .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static List<UserWagon> getByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<UserWagon> userWagon = (List<UserWagon>)
                session.createQuery("FROM user_wagons uw WHERE uw.user.id = :id")
                        .setParameter("id", id).list();
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static UserWagon getByClientId(String clientId) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        UserWagon userWagon = (UserWagon)
                session.createQuery("FROM user_wagons uw WHERE uw.clientId = :clientId")
                        .setParameter("clientId", clientId).getSingleResult();
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }

//    @Test
//    public void kek() {
//        UserDAO.persist(new User(new Date(), new Date(), "", "aman", "password", "user"));
//        UserWagonDAO.persist(new UserWagon(UserDAO.getById(1), "araninho", WagonCacheDAO.getById(1)));
//        UserWagonDAO.getByUserId(1).forEach(users -> System.out.println(users.getClientId()));
//
//       List<Position> positions = Arrays.asList(new Position());
//        List<Repair> repairs = Arrays.asList(new Repair());
//        WagonCacheDAO.persist(new WagonCache(positions, new UserWagon(), new Date(), (long) 123, "123",
//                "Almaty", (long) 123, (long) 123, "Almaty", 28.4, 28.4,
//                "Astana", (long) 123, (long) 123, (long) 123, 28.5, 24.5, 45.5,
//                "5645640", new Date(), (long) 1233, (long) 123, (long) 123, new Date(), new Date(), "asd",
//                (long) 123, "AlterApp", "asd", "asd", 123, 25.4,
//                25.5, "sad", "asd", new Date(), new Date(), 123, 25.5,
//                123, 123, "sad", 123, 123,
//                "asd", 123, "asd", 546, 546,
//                564, 564, 852, 852, 7.5,
//                852, 87, 564, 52.4, 654, 25.4,
//                564, 654, new Date(), "asd", 852, new Date(), new Date(),
//                new Date(), new Date(), 564, new Date(), 564, new Date(), new Date(), repairs));
//        WagonCacheDAO.getAllWagonCacheByUserId(1).forEach(wagons -> System.out.println(wagons.getClient_id()));
//        System.out.println(WagonCacheDAO.getByClientId("123").getFrom_code());
//    }
}
