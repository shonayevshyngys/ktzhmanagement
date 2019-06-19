package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.User;
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
