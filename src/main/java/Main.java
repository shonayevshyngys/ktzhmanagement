import org.hibernate.Session;
import org.hibernate.Transaction;
import server.domain.HibernateUtils;
import server.domain.UniversalDAO;
import server.domain.model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user = new User(LocalDate.now(),LocalDate.now(),"token", "username", "pass", "user" );
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }
}
