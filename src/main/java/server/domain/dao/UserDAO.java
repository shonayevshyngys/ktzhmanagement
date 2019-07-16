package server.domain.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.SQLGrammarException;
import server.domain.HibernateUtils;
import server.domain.model.User;
import server.domain.model.UserWagon;
import server.domain.model.WagonCache;

import javax.persistence.NoResultException;
import java.util.List;

@SuppressWarnings("unchecked")
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
        User user = null;
        try {
            user = (User) session.createQuery("FROM Users u WHERE u.id = :id").setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            System.err.print("No user found by ");
            System.out.println("USER_ID");
        }
        transaction.commit();
        session.close();
        return user;
    }

    public static List<UserWagon> getAllUserWagonByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<UserWagon> userWagons = null;
        try {
            userWagons = (List<UserWagon>)
                    session.createQuery("From user_wagons uw WHERE uw.user.id = :id")
                            .setParameter("id", id)
                            .list();
            userWagons.forEach(wagon -> {
                Hibernate.initialize(wagon.getWagonCacheId().getPositions());
                Hibernate.initialize(wagon.getWagonCacheId().getRepairs());
            });
        } catch (NoResultException | NullPointerException e) {
            System.err.print("No userWagons found by ");
            System.out.println("USER_ID");
        } catch (SQLGrammarException sge) {
            System.out.println("UserDAO - getAllUserWagonByUserId: Query error");
        }
        transaction.commit();
        session.close();
        return userWagons;
    }

    public static List<WagonCache> getAllWagonCacheByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        List<WagonCache> wagonCaches = null;
        try {
            wagonCaches = (List<WagonCache>)
                    session.createQuery("From wagon_cache wc WHERE wc.userWagonId.id = :id")
                            .setParameter("id", id)
                            .list();
        } catch (NoResultException nre) {
            System.err.print("No wagonCaches found by ");
            System.out.println("USER_ID");
        }
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
        List<User> users = null;
        try {
            users = (List<User>) session.createQuery("FROM Users").list();
        } catch (NoResultException nre) {
            System.err.print("No ");
            System.out.print("USERS ");
            System.err.println("found");
        }

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
        User user = null;
        try {
            user = (User) session
                    .createQuery("FROM Users u WHERE u.username = :username")
                    .setParameter("username", username).getSingleResult();
            Hibernate.initialize(user.getUserWagons());
            transaction.commit();
        } catch (NoResultException e) {
            System.err.print("No user found by ");
            System.out.println("USERNAME");
        } catch (SQLGrammarException e) {
            System.err.println("UserDAO - getByUsername: Query error");
        }
        session.close();
        return user;
    }

    public static boolean update(User user) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
        } catch (IllegalArgumentException iae) {
            System.err.println("Can not update ");
            System.out.println("USER");
            session.close();
            return false;
        }

        transaction.commit();
        session.close();
        return true;
    }

    public static boolean updateById(long id) {
        return update(getById(id));
    }

    public static boolean updateByUsername(String username) {
        return update(getByUsername(username));
    }

    public static boolean delete(User user) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
        } catch (IllegalArgumentException iae) {
            System.err.print("Can not delete the ");
            System.out.println("USER");
            session.close();
            return false;
        }

        transaction.commit();
        session.close();
        return true;
    }

    public static boolean deleteById(long id) {
        return delete(getById(id));
    }

    public static boolean deleteByUsername(String username) {
        return delete(getByUsername(username));
    }

}
