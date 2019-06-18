package server.web.Handlers;

import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import org.jetbrains.annotations.NotNull;
import server.client.WagonClient;
import server.web.Utils.TokenHandler;
import server.web.Utils.UserData;


public class WagonController implements CrudHandler {

    @Override
    public void create(@NotNull Context context) {
        UserData userData = new UserData(context);
        //add wagon
        //WagonClient.addWagon()
    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        UserData userData = new UserData(context);
        int param = Integer.valueOf(s);
        //take off wagon

        //check for if this wagon exists in list of user wagons
    }

    @Override
    public void getAll(@NotNull Context context) {
        UserData userData = new UserData(context);
        //get all user's wagons from cache
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        UserData userData = new UserData(context);
        // get one wagon from cache
    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        UserData userData = new UserData(context);
        int param = Integer.valueOf(s);
        //update wagon and write it into cache
        //TODO implement update through delete + insert
    }

}
