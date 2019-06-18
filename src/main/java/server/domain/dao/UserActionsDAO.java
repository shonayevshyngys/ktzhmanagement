package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.User;
import server.domain.model.UserAction;

import java.util.List;

public class UserActionsDAO {
    public static void persist(UserAction userAction) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(userAction);
        transaction.commit();
        session.close();
    }

    public static User getByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session
                .createQuery("FROM Users u WHERE u.id = :id")
                .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    public static UserAction getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        UserAction userAction = (UserAction)
                session.createQuery("FROM user_actions ua WHERE ua.id = :id")
                        .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return userAction;
    }

    public static List<UserAction> getByActionType(String actionType) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<UserAction> userActions = (List<UserAction>) session
                .createQuery("FROM user_actions ua WHERE ua.action = :actionType")
                .setParameter("actionType", actionType).list();
        transaction.commit();
        session.close();
        return userActions;
    }

    public static void delete(UserAction userAction) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userAction);
        transaction.commit();
        session.close();
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }
}
