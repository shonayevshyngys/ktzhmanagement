package server.web.Handlers;

import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import server.client.WagonClient;
import server.client.WagonDeserealizator;
import server.client_model.Data;
import server.domain.dao.UserActionsDAO;
import server.domain.dao.UserDAO;
import server.domain.dao.WagonCacheDAO;
import server.domain.model.User;
import server.domain.model.UserAction;
import server.domain.model.WagonCache;
import server.web.Utils.UserData;
import server.web.request_models.CreateWagon;
import server.web.response_models.ErrorResponse;
import server.web.response_models.SuccessMessage;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class WagonController implements CrudHandler {

    @Override
    public void create(@NotNull Context context) {
        //post
        UserData userData = new UserData(context);  //get info from session
        CreateWagon cw = context.bodyAsClass(CreateWagon.class); //get info from post body
        User u = UserDAO.getByUsername(userData.getUsername());
        String client_id = u.getUsername() + cw.getNo_wagon(); //creating client_id
        WagonClient.addWagon(cw.getNo_wagon(), cw.getFrom(), cw.getTo(), cw.getSend_day(), true, client_id, cw.getTakeoff_day())
                .subscribe(new SingleObserver<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.err.println("getting data from server");
                    }

                    @Override
                    public void onSuccess(ResponseBody responseBody) {
                        try {
                            Data data = WagonDeserealizator.getData(responseBody.string());
                            String status = data.getResult().getStatus();
                            if (status.equals("OK")) {
                                context.status(200);
                                context.json(new SuccessMessage("Successfuly added wagon"));
                                UserActionsDAO.persist(new UserAction("add_wagon", new Date(), context.ip(), context.userAgent(), u)); //add an action id
                            } else {
                                context.status(400);
                                context.json(new ErrorResponse("It wasn't successfuly added"));

                                // check up if takes money to not add wagon
                            }
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        context.status(400);
                        context.json(new ErrorResponse("Didnt connect to latyshi"));
                    }
                });

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
        User u = UserDAO.getByUsername(userData.getUsername());
        List<WagonCache> wc = WagonCacheDAO.getAllWagonCacheByUserId(u.getId());

        if (!wc.isEmpty()) {
            context.status(200);
            context.json(wc);

        } else if (wc == null) {
            context.status(400);
        } else {
            context.status(200);
            context.json(new ErrorResponse("Here is no list of the WagonCache"));
        }
        //get all user's wagons from cache
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        //get with param
        UserData userData = new UserData(context);
        User u = UserDAO.getById(Long.valueOf(userData.getId()));
        u.getUserWagons().forEach(userWagon -> {
            if (userWagon.getClientId().equals(userData.getUsername() + s)) {
                context.status(200);
                context.json(userWagon);
            }
        });
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
