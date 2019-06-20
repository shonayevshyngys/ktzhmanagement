import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import server.client.WagonClient;
import server.client.WagonDeserealizator;
import server.client_model.Data;
import server.domain.HibernateUtils;
import server.domain.dao.UserDAO;
import server.domain.model.User;
import server.web.Utils.DateParser;
import server.web.Utils.HashUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        HibernateUtils.getSession().close();
        // WagonCache wagonCache = new WagonCache(new);
        //WagonCacheDAO.persist(wagonCache);
//        UserDAO.persist(new User(new Date(), new Date(), "", "aman31", HashUtils.hashPassword("password"), "user"));
//        UserWagonDAO.persist(new UserWagon(UserDAO.getById(6),"aman", WagonCacheDAO.getById(1)));
//    UserDAO.getAllUserWagonByUserId(6).forEach(wagons -> {
//        System.out.println(wagons.getClientId());
//    });
//        PositionDAO.getAllPositionsByUserWagonId(1).forEach(position -> System.out.println(position.toString()));
//        WagonCache wagonCache = WagonCacheDAO.getWagonCacheByUserWagonId(6);
//        wagonCache.getPositions().forEach(position -> System.out.println(position.getId()));
//        wagonCache.getRepairs().forEach(repair -> System.out.println(repair.getId()));
//        System.out.println(WagonCacheDAO.getById(1).getVagon_no());
//        System.out.println(UserWagonDAO.getByClientId("aman270710967").getId());
//        List<Position> positions = new ArrayList<>();
//        List<Repair> repairs = new ArrayList<>();
//        WagonCache cache = new  WagonCache(positions, UserWagonDAO.getByClientId("aman270710967"),
//                data.getVagon().get(0).getVagon_info(), repairs);
//        String str = "19.06.2019";
//        String format = "dd.MM.yyyy";
//
////        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        ParsePosition parsePosition = new ParsePosition(0);
//     Date date = dateFormat.parse(str, parsePosition);
//        System.out.println(DateParser.parseFromStringToDate(str, format));
        new WagonClient();
        WagonClient.getUserWagons(true).subscribe(new SingleObserver<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                try {
                    Data data = WagonDeserealizator.getData(responseBody.string());
                    data.getVagon().forEach(vagon -> {
                        vagon.getVagon_info().getLast_repairs().getRepair().forEach(repair -> {
                            System.out.println(repair.getDefects().getDefect().getDescription());
                        });
                        System.out.println("___________________Следующий вагон________________________________");
                    });
                } catch (JAXBException | IOException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
