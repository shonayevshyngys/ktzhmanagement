import io.javalin.Handler;
import io.javalin.Javalin;
import server.client.WagonClient;
import server.web.Handlers.AdminHandler;
import server.web.Handlers.LoginHandler;
import server.web.Handlers.VagonHandler;
import server.web.JWT.JavalinJWT;
import server.web.Utils.Roles;
import server.web.Utils.TokenHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static void main(String[] args) {
        Javalin app  = Javalin.create()
                .enableDebugLogging();  //for debug

        app.accessManager(TokenHandler.jhandler.getAccessManager()); //init access manager
        app.start(1200);

        //init client
        WagonClient wc = new WagonClient();

        //jwt decoder
        Handler decodeHandler = JavalinJWT.createHeaderDecodeHandler(TokenHandler.jhandler.getProvider());
        app.before(decodeHandler);
        //the end of jwt decoder


        //routing
        app.routes(() -> {
            path("/login", () -> {
                post(new LoginHandler(), Collections.singleton(Roles.ANYONE));
            });
            path("/vagon/:id", () ->{
                get(new VagonHandler(), new HashSet<>(Arrays.asList(Roles.USER, Roles.ADMIN)));
            });

        });
    }
}
