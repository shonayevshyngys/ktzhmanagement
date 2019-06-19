package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.User;
import server.domain.model.UserWagon;
import server.domain.model.WagonCache;
import server.web.response_models.UserResponse;

import java.util.List;

public class UserDAO {
    public static void persist(User user) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public static User getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery("FROM Users u WHERE u.id = :id").setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    public static List<UserWagon> getAllUserWagonByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        @SuppressWarnings({"unchecked", "duplicate"})
        List<UserWagon> userWagons =
                (List<UserWagon>)
                        session.createQuery("From user_wagons uw WHERE uw.user.id = :id")
                                .setParameter("id", id)
                                .list();

//        users.forEach(user -> {
//            user.getUserActionList().forEach(ual -> System.out.println(ual.getAction()));
//        });
//        userWagons.forEach(userWagon -> {
//        userWagon.getWagonCacheId()
//                .setPositions(PositionDAO.getAllPositionsByUserWagonId(userWagon.getId()));
//        userWagon.getWagonCacheId().setRepairs(RepairDAO.getAllRepairsByUserWagonId(userWagon.getId()));
//        });
        userWagons.forEach(userWagon -> {
            System.out.println(userWagon.getWagonCacheId().getRepairs());
            System.out.println(userWagon.getWagonCacheId().getClient_id());

        });
        transaction.commit();
        session.close();
        return userWagons;
    }

    public static List<WagonCache> getAllWagonCacheByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings({"unchecked", "duplicated"})
        List<WagonCache> wagonCaches =
                (List<WagonCache>)
                        session.createQuery("From wagon_cache wc WHERE wc.userWagonId.id = :id")
                                .setParameter("id", id)
                                .list();

//        users.forEach(user -> {
//            user.getUserActionList().forEach(ual -> System.out.println(ual.getAction()));
//        });
        transaction.commit();
        session.close();
        return wagonCaches;
    }

    public static List<User> getAllUsers() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<User> users = (List<User>) session.createQuery("From Users").list();

//        users.forEach(user -> {
//            user.getUserActionList().forEach(ual -> System.out.println(ual.getAction()));
//        });
        transaction.commit();
        session.close();
        return users;
    }

    public static User getByUsername(String username) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session
                .createQuery("FROM Users u WHERE u.username = :username")
                .setParameter("username", username).getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    public static void update(User user) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public static void updateById(long id) {
        update(getById(id));
    }

    public static void updateByUsername(String username) {
        update(getByUsername(username));
    }

    public static void delete(User user) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }

    public static void deleteByUsername(String username) {
        delete(getByUsername(username));
    }

}
