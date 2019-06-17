package server.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UniversalDAO {
    public static void persist(Object o) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(o);

        transaction.commit();
        session.close();
    }

    public static void update(Object o) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(o);

        transaction.commit();
        session.close();
    }

    public static void delete(Object o) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(o);

        transaction.commit();
        session.close();
    }

    public static void deleteById(long id, Class<?> clazz) {
        delete(getById(id, clazz));
    }

    public static Object getById(long id, Class<?> clazz) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Object o = session.load(clazz, id);

        transaction.commit();
        session.close();

        return o;
    }

    public static void updateById(long id, Class<?> clazz) {
        update(getById(id, clazz));
    }
}
