package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;
import server.web.Utils.TokenHandler;
import server.domain.model.User;
import server.web.request_models.Credentials;
import server.web.response_models.ErrorResponse;
import server.web.response_models.JwtResponse;

import java.time.Instant;
import java.util.Date;

public class LoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Credentials cr = context.bodyAsClass(Credentials.class);
        if (cr.getUsername().equals("admin") && cr.getPassword().equals("password")){

        }
        else
        {
            context.status(401);
            context.json(new ErrorResponse("Bad credentials"));
        }
    }
}
