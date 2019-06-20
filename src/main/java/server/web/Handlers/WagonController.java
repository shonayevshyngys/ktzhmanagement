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
import server.client_model.Vagon_info;
import server.domain.dao.*;
import server.domain.model.*;
import server.web.Utils.UserData;
import server.web.request_models.CreateWagon;
import server.web.response_models.ErrorResponse;
import server.web.response_models.SuccessMessage;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WagonController implements CrudHandler {

    @Override
    public void create(@NotNull Context context) {
        //post
        UserData userData = new UserData(context);  //get info from session
        CreateWagon cw = context.bodyAsClass(CreateWagon.class); //get info from post body
        System.out.println("Deserealization passed");
        User u = UserDAO.getByUsername(userData.getUsername());
        String client_id = u.getUsername() + cw.getNo_wagon(); //creating client_id
        System.out.println("Creating new client wagon" + " " + client_id);
        WagonClient.addWagon(cw.getNo_wagon(), cw.getFrom(), cw.getTo(), cw.getSend_day(), true, client_id, cw.getTakeoff_day())
                .subscribe(new SingleObserver<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("getting data from server");
                    }

                    @Override
                    public void onSuccess(ResponseBody responseBody) {
                        try {
                            Data data = WagonDeserealizator.getData(responseBody.string());
                            String status = data.getResult().getStatus();
                            if (status.equals("OK")) {
                                context.status(200);
                                context.json(new SuccessMessage("Successfuly added wagon"));
                                System.out.println("Successfully added wagon");

                                UserActionsDAO.persist(new UserAction("add_wagon", new Date(), context.ip(), context.userAgent(), u));
                                System.out.println("Saved user action");
                                UserWagonDAO.persist(new UserWagon(u, u.getUsername() + cw.getNo_wagon(), null));
                                System.out.println("Created new UserWagon");
                                setWagon(u, cw, context);
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
    public void delete(@NotNull Context context, @NotNull String param) {
        //delete
        UserData userData = new UserData(context);
        User user = UserDAO.getByUsername(userData.getUsername());
//        List<UserWagon> uw = UserWagonDAO.getByUserId(Long.valueOf(param));
        if (user.getUserWagons().stream().filter(b -> b.getClientId().equals(user.getUsername() + param)).findFirst().orElse(null) != null) {
            WagonClient.takeOff(user.getUsername() + param).subscribe(new SingleObserver<ResponseBody>() {
                @Override
                public void onSubscribe(Disposable disposable) {
                    System.err.println("taking off data from server");
                }

                @Override
                public void onSuccess(ResponseBody responseBody) {

                    try {
                        if (getStatus(responseBody.string())) {
                            //TODO implement delete by client_id in userWagon and delete userWagon `Scorpion: Get over here' over there
                            WagonCacheDAO.delete(WagonCacheDAO.getByClientId(user.getUsername() + param));
                        } else {
                            context.status(400);
                            context.json(new ErrorResponse("Something went wrong"));
                        }
                    } catch (IOException e) {
                        context.status(400);
                        context.json(new ErrorResponse("Something went wrong"));
                        e.printStackTrace();
                    }

//                if(WagonCacheDAO.getWagonCacheByWagonNo(param) != null){
//                    WagonCacheDAO.delete(WagonCacheDAO.getWagonCacheByWagonNo(param));
//                    context.status(200);
//                }
//                else {
//                    context.status(400);
//                    context.json(new ErrorResponse("There is not such wagon"));
//
//                }
                }

                @Override
                public void onError(Throwable throwable) {
                    context.status(400);
                    context.json(new ErrorResponse("Didnt connect to latyshi"));
                }
            });
        }

        //take off wagon

        //check for if this wagon exists in list of user wagons

    }

    @Override
    public void getAll(@NotNull Context context) {
        //get w/o params
        UserData userData = new UserData(context);
        List<UserWagon> uw = UserDAO.getAllUserWagonByUserId(Long.valueOf(userData.getId()));

        if (!uw.isEmpty()) {
            context.status(200);
            context.json(uw);

        } else if (uw == null) {
            context.status(400);
        } else {
            context.status(200);
            context.json(new ErrorResponse("There is no list of the WagonCache"));
        }
        //get all user's wagons from cache
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        //get with param
        UserData userData = new UserData(context);
        System.out.println(userData.getUsername());
        System.out.println(userData.getId());
        System.out.println(userData.getRole());
//        List<WagonCache> wc = UserDAO.getAllWagonCacheByUserId(Long.valueOf(userData.getId()));
        List<UserWagon> uw =
                UserDAO.getAllUserWagonByUserId(Long.valueOf(userData.getId()));
        uw.forEach(userWagon -> {
            if (userWagon.getClientId().equals(userData.getUsername() + s)) {
//                userWagon.getWagonCacheId()
//                        .setPositions(WagonCacheDAO.getAllWagonPositionsByUserWagonId(userWagon.getId()));
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

    private boolean getStatus(String xml) {
        return xml.contains("<status>OK</status>");
    }

    private void setWagon(User u, CreateWagon cw, Context context) {
        WagonClient.viewWagons(true, u.getUsername() + cw.getNo_wagon()).subscribe(new SingleObserver<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Waiting for response");
            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                try {
                    UserActionsDAO.persist(new UserAction("get_wagon", new Date(), context.ip(), context.userAgent(), u));
                    UserWagon userWagon = UserWagonDAO.getByClientId(u.getUsername() + cw.getNo_wagon());
                    System.out.println("created transient userWagon");
                    Data data = WagonDeserealizator.getData(responseBody.string());
                    Vagon_info vagon_info = data.getVagon().get(0).getVagon_info();
                    System.out.println("got vagon_info");
                    List<Position> positions = new ArrayList<>();
                    List<Repair> repairs = new ArrayList<>();
                    System.out.println("Starting to write to cache");
                    WagonCache cache = new WagonCache(positions, new Date(), userWagon, vagon_info, repairs);
                    WagonCacheDAO.persist(cache);

                    UserWagon uw = UserWagonDAO.getByClientId(u.getUsername() + cw.getNo_wagon());
                    uw.setWagonCacheId(cache);
                    UserWagonDAO.update(uw);
                    WagonCache wc = WagonCacheDAO.getByUserWagonClientId(u.getUsername() + cw.getNo_wagon());
                    //fix check up on success

                    ///
                    for (int pos1 = 0; pos1 < data.getVagon().get(0).getVagon_info().getLast_repairs().getRepair().size(); pos1++) {
                        repairs.add(new Repair(data.getVagon().get(0).getVagon_info().getLast_repairs().getRepair().get(pos1), wc));
                        RepairDAO.persist(repairs.get(pos1));
                    }
                    System.out.println("Created transient cache");
                    wc.setRepairs(repairs);
                    WagonCacheDAO.update(wc);

                    System.out.println("Successfully updated");
                } catch (JAXBException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }
}
