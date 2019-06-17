package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.eclipse.jetty.util.security.Credential;
import org.jetbrains.annotations.NotNull;
import server.web.Utils.HashUtils;
import server.web.Utils.JWThandler;
import server.web.Utils.TokenHandler;
import server.domain.model.User;
import server.web.request_models.Credentials;
import server.web.response_models.ErrorResponse;
import server.web.response_models.JwtResponse;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class LoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Credentials cr = context.bodyAsClass(Credentials.class);
        if (cr.getUsername().equals("admin") && cr.getPassword().equals("password")){
            User user = new User(LocalDate.now(), LocalDate.now(), "", "admin", HashUtils.hashPassword(cr.getPassword()), "admin");
            String token = TokenHandler.jhandler.getToken(user);
            user.setToken(token);
            context.json(new JwtResponse(token));
        }
        else
        {
            context.status(401);
            context.json(new ErrorResponse("Bad credentials"));
        }
    }
}
