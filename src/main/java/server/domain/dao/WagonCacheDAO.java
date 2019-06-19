package server.domain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.User;
import server.domain.model.UserWagon;
import server.domain.model.WagonCache;

import java.util.List;

public class WagonCacheDAO {

    public static void persist(WagonCache wagonCache) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(wagonCache);
        transaction.commit();
        session.close();
    }

    public static WagonCache getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        WagonCache wagonCache = (WagonCache) session.createQuery("FROM wagon_cache wc WHERE wc.id = :id")
                .setParameter("id", id).getSingleResult();
        transaction.commit();
        session.close();
        return wagonCache;
    }

    public static WagonCache getByWagonNo(long no) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        WagonCache wagonCache = (WagonCache) session.createQuery("FROM wagon_cache wc WHERE wc.vagon_no = :no")
                .setParameter("no", no).getSingleResult();
        transaction.commit();
        session.close();
        return wagonCache;
    }

    public static WagonCache getByClientId(String clientId) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        WagonCache wagonCache = (WagonCache) session.createQuery("FROM wagon_cache wc WHERE wc.client_id = :clientId")
                .setParameter("clientId", clientId).getSingleResult();
        transaction.commit();
        session.close();
        return wagonCache;
    }

    public static List<WagonCache> getAllWagonCacheByUserId(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings({"unchecked", "dupllicate"})
        List<WagonCache> wagonCacheList = (List<WagonCache>) session
                .createQuery("From wagon_cache wc " +
                        "WHERE wc.userWagonId.user.id = :id")
                .setParameter("id", id).list();
        transaction.commit();
        session.close();
        return wagonCacheList;
    }

    public static void update(WagonCache wagonCache) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(wagonCache);
        transaction.commit();
        session.close();
    }

    public static void updateById(long id) {
        update(getById(id));
    }

    public static void delete(WagonCache wagonCache) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(wagonCache);
        transaction.commit();
        session.close();
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }

}
