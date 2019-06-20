package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
