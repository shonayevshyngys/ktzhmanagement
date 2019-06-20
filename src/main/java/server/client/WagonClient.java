package server.client;


import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import server.client_model.Data;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public class WagonClient {
    public static final String BASE_URL = "https://www.railwagonlocation.com/";
    private static WagonAPI api;
    private Retrofit rf;


    public WagonClient() {
        rf = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = rf.create(WagonAPI.class);
    }

    public static Single<ResponseBody> addWagon(String wagonNo,
                                                String from, String to, String sendDay, boolean roundWagon,
                                                String clientId, String takeOffDay) {
        String url = URLbuilder.newBuilder()
                .addRequestType("add_vagon")
                .addWagonNo(wagonNo)
                .addFrom(from)
                .addTo(to)
                .addSendDay(sendDay)
                .addRoundWagon(roundWagon ? "y" : "n")
                .addClientId(clientId)
                .addTakeOffDay(takeOffDay)
                .set()
                .build();
        return api.getWagon(url);
    }

    public static Single<ResponseBody> getWagon(String wagonNo) {
        String url = URLbuilder.newBuilder()
                .addRequestType("get_vagon")
                .addWagonNo(wagonNo)
                .set()
                .build();
        return api.getWagon(url);
    }

    public static Single<ResponseBody> getUserWagons(boolean allOperations) {
        String url = URLbuilder.newBuilder()
                .addRequestType("get_user_vagons")
                .addAllOperations(allOperations ? "y" : "n")
                .set()
                .build();
        return api.getWagon(url);
    }

    public static Single<ResponseBody> takeOff(String... clientIds) {
        String url = URLbuilder.newBuilder()
                .addRequestType("take_off_vagons")
                .addClientIds(clientIds)
                .set()
                .build();
        return api.getWagon(url);
    }

    public static Single<ResponseBody> viewWagons(boolean allOperations, String... clientIds) {
        String url = URLbuilder.newBuilder()
                .addRequestType("view_vagons")
                .addAllOperations(allOperations ? "y" : "n")
                .addClientIds(clientIds)
                .set()
                .build();
        System.out.println(url);
        System.out.println(api.getWagon(url).toString());
        return api.getWagon(url);
    }


    public static void main(String[] args) {
        String url = URLbuilder.newBuilder()
                .addRequestType("take_off_vagons")
                .addClientIds("aman10170710967")
                .set()
                .build();
        System.out.println(url);
    }

}
