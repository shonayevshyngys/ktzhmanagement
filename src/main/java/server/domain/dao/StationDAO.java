package server.domain.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.model.Station;
import server.domain.model.Station;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


@SuppressWarnings("unchecked")
public class StationDAO {
    public static void persist(Station station) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(station);

        transaction.commit();
        session.close();
    }

    public static void update(Station station) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(station);

        transaction.commit();
        session.close();
    }

    public static void delete(Station station) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(station);

        transaction.commit();
        session.close();
    }

    public static void deleteById(long id) {
        delete(getById(id));
    }

    public static Station getById(long id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Station station = null;

        try {
            station = (Station) session.createQuery("FROM Stations s where s.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            System.err.println("No station found by ");
            System.out.println("STATION_ID");
        }

        transaction.commit();
        session.close();

        return station;
    }

    public static Station getFiveToSixStation(Long fdn) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Station station = null;

        try {
            station = (Station) session.createQuery("FROM Stations s where s.serialNumber = :fdn")
                    .setParameter("fdn", fdn).getSingleResult();
        } catch (NoResultException nre) {
            System.err.println("No station found by ");
            System.out.println("FIVE_DIGIT_NUMBER");

        }

        transaction.commit();
        session.close();

        return station;
    }

    public static void updateById(long id) {
        update(getById(id));
    }

    public static void initStations() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            String q = new String(Files.readAllBytes(Paths.get("src/main/resources/stations_insert.sql")));
            SQLQuery sqlQuery = session.createSQLQuery(q).addEntity(Station.class);
            sqlQuery.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
    }

    public static List<Station> getAllStations() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        List<Station> stations = null;
        try {
            stations = (List<Station>) session.createQuery("FROM Stations ").list();
        } catch (NoResultException nre) {
            System.err.print("No ");
            System.out.print("STATIONS ");
            System.err.println("found");
        }
        
        transaction.commit();
        session.close();
        return stations;
    }
}
