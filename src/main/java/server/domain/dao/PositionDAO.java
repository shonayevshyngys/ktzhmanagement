package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.Position;

import java.util.List;

public class PositionDAO {

    public static void persist(Position position) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(position);
        transaction.commit();
        session.close();
    }

    public static void update(Position positiono) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(positiono);

        transaction.commit();
        session.close();
    }

    public static void delete(Position position) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(position);
        transaction.commit();
        session.close();
    }

    public static List<Position> getAllPositions() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Position> positions = (List<Position>) session.createQuery("From server.domain.model.Position").list();
        transaction.commit();
        session.close();
        return positions;
    }

    public static Position getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Position position = (Position)
                session.createQuery("FROM positions p WHERE p.id = :id")
                        .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return position;
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }
}
