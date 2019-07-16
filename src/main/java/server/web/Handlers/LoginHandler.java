package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;
import server.domain.dao.UserActionsDAO;
import server.domain.dao.UserDAO;
import server.domain.model.User;
import server.domain.model.UserAction;
import server.web.Utils.HashUtils;
import server.web.Utils.TokenHandler;
import server.web.request_models.Credentials;
import server.web.response_models.ErrorResponse;
import server.web.response_models.JwtResponse;

import java.util.Date;

public class LoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) {
        Credentials cr = context.bodyAsClass(Credentials.class);
        //check
        User u = UserDAO.getByUsername(cr.getUsername());
        if (u != null && HashUtils.checkPassword(cr.getPassword(), u.getPassword())) {
            context.status(200);
            String token = TokenHandler.jhandler.getToken(u);
            u.setToken(token);
            u.setLastLoginTime(new Date());
            UserDAO.update(u);
            System.out.println(u.getId());
            UserActionsDAO.persist(new UserAction("logged_in", new Date(), context.ip(), context.userAgent(), u));

            context.json(new JwtResponse(token));
        } else {
            context.status(401);
            context.json(new ErrorResponse("Bad credentials"));
        }

    }
}

