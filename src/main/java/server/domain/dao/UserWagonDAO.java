package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.exception.SQLGrammarException;
import server.domain.HibernateUtils;
import server.domain.model.UserWagon;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

@SuppressWarnings("unchecked")
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

    public static boolean delete(UserWagon userWagon) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(userWagon);
        } catch (IllegalArgumentException iae) {
            System.err.print("Can not delete the ");
            System.out.println("USERWAGON");
            return false;
        }

        transaction.commit();
        session.close();
        return true;
    }

    public static UserWagon getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        UserWagon userWagon = null;
        try {
            userWagon = (UserWagon)
                    session.createQuery("FROM user_wagons uw WHERE uw.id = :id")
                            .setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            System.err.print("No userWagon found by ");
            System.out.println("USERWAGON_ID");
        }
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static List<UserWagon> getByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        List<UserWagon> userWagon = null;
        try {
            userWagon = (List<UserWagon>)
                    session.createQuery("FROM user_wagons uw WHERE uw.user.id = :id")
                            .setParameter("id", id).list();
        } catch (NoResultException nre) {
            System.err.print("No userWagons found by ");
            System.out.println("USER_ID");
        }
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static UserWagon getByClientId(String clientId) {
        System.out.println(clientId);
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        UserWagon userWagon = null;
        try {
            userWagon = (UserWagon)
                    session.createQuery("FROM user_wagons uw WHERE uw.clientId = :clientId")
                            .setParameter("clientId", clientId).getSingleResult();
        } catch (PersistenceException e) {
            System.err.print("No userWagon found by ");
            System.out.println("CLIENT_ID");
        }
        transaction.commit();
        session.close();
        return userWagon;
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }

}
