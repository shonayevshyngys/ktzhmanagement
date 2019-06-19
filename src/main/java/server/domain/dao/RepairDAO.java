package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.Repair;

import java.util.List;

public class RepairDAO {
    //todo add another methods
    public static void persist(Repair repair) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(repair);
        transaction.commit();
        session.close();
    }

    //TODO change update
    public static void update(Repair repair) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(repair);

        transaction.commit();
        session.close();
    }

    public static void delete(Repair repair) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(repair);
        transaction.commit();
        session.close();
    }

    public static List<Repair> getAllRepairs() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Repair> repairs = (List<Repair>) session.createQuery("From server.domain.model.Repair").list();
        transaction.commit();
        session.close();
        return repairs;
    }

    public static List<Repair> getAllRepairsByUserWagonId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings({"unchecked", "duplicated"})
        List<Repair> repairs = (List<Repair>) session
                .createQuery("from Repairs r where r.wagonId.userWagonId.id = :id")
                .setParameter("id", id).list();
        transaction.commit();
        session.close();
        return repairs;
    }

    public static Repair getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Repair position = (Repair)
                session.createQuery("FROM Repairs r WHERE r.id = :id")
                        .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return position;
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }
}
