package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import server.domain.HibernateUtils;
import server.domain.UniversalDAO;
import server.domain.model.User;
import server.domain.model.UserAction;
import server.web.Utils.HashUtils;
import server.web.Utils.JWThandler;
import server.web.Utils.TokenHandler;
import server.web.request_models.Credentials;
import server.web.response_models.ErrorResponse;
import server.web.response_models.JwtResponse;

import java.time.LocalDate;

public class LoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Credentials cr = context.bodyAsClass(Credentials.class);
        //test, clean up
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        String username = cr.getUsername();
        String hql = "FROM server.domain.model.User s where s.username = :username" ;
        User user = (User)session.createQuery(hql).setParameter("username", username).getSingleResult();
        //check for null
        if (HashUtils.checkPassword(cr.getPassword(), user.getPassword())){
            String token = TokenHandler.jhandler.getProvider().generateToken(user);
            context.status(200);
            context.json(new JwtResponse(token));
            tr.commit();
            session.close();
            UniversalDAO.persist(new UserAction("logged in", LocalDate.now(), context.ip(), context.userAgent(), user));
        }
        else {
            context.status(401);
            context.json(new ErrorResponse("bad credentials"));
            session.close();
        }

        }
    }
