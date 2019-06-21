import io.javalin.Handler;
import io.javalin.Javalin;
import server.client.WagonClient;
import server.domain.HibernateUtils;
import server.web.Handlers.*;
import server.web.JWT.JavalinJWT;
import server.web.Utils.Roles;
import server.web.Utils.TokenHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static io.javalin.apibuilder.ApiBuilder.crud;

public class App {
    public static void main(String[] args) {
        Javalin app  = Javalin.create()
                .enableDebugLogging().enableCorsForAllOrigins();  //for debug


        app.accessManager(TokenHandler.jhandler.getAccessManager()); //init access manager
        app.start(1228);

        //init client
        WagonClient wc = new WagonClient();

        HibernateUtils.getSession();
        //jwt decoder
        Handler decodeHandler = JavalinJWT.createHeaderDecodeHandler(TokenHandler.jhandler.getProvider());
        app.before(decodeHandler);
        //the end of jwt decoder


        //routing
        app.routes(() -> {
            crud("/wagon/:id", new WagonController(), new HashSet<>(Arrays.asList(Roles.USER)));
            app.post("/login", new LoginHandler(), Collections.singleton(Roles.ANYONE));
            app.patch("/update_all_user_wagons", new AllUserWagonsHandler(), Collections.singleton(Roles.USER));
            app.get("/user_info",new UserInfoHandler(), Collections.singleton(Roles.USER) );


            //admin
            app.post("/admin", new AdminLoginHandler(), Collections.singleton(Roles.ANYONE));
            crud("/users/:id", new UserController(), Collections.singleton(Roles.ADMIN));

        });
    }
}
