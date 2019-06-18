package server.web.Handlers;

import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import org.jetbrains.annotations.NotNull;
import server.client.WagonClient;
import server.web.Utils.TokenHandler;
import server.web.Utils.UserData;
import server.web.request_models.CreateWagon;


public class WagonController implements CrudHandler {

    @Override
    public void create(@NotNull Context context) {
        //post
        UserData userData = new UserData(context);
        CreateWagon cw = context.bodyAsClass(CreateWagon.class);

        //add wagon
    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        //delete
        UserData userData = new UserData(context);
        int param = Integer.valueOf(s);
        //take off wagon

        //check for if this wagon exists in list of user wagons
    }

    @Override
    public void getAll(@NotNull Context context) {
        //get w/o params
        UserData userData = new UserData(context);
        //get all user's wagons from cache
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        //get with param
        UserData userData = new UserData(context);
        // get one wagon from cache
    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        //patch

        UserData userData = new UserData(context);
        long param = Long.valueOf(s);
        //update wagon and write it into cache
        //TODO implement update through delete + insert
    }

}
