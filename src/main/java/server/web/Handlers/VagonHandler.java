package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;
import server.web.Utils.TokenHandler;

public class VagonHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String role = TokenHandler.jhandler.getPayload(context).getClaim("role").asString();
        String name = TokenHandler.jhandler.getPayload(context).getClaim("username").asString();
        context.result("hello "+name+" and your role is "+role);
    }
}
