package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;

public class AdminHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.result("hello admin");
    }
}
