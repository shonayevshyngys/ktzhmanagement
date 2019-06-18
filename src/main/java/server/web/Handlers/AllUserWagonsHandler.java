package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;
import server.web.Utils.TokenHandler;
import server.web.Utils.UserData;

public class AllUserWagonsHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        UserData userData = new UserData(context);

    }
}
