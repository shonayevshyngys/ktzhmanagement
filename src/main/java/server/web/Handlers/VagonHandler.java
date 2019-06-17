package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import server.client.WagonClient;
import server.client.WagonDeserealizator;
import server.client_model.Vagon;
import server.web.Utils.TokenHandler;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class VagonHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        //String role = TokenHandler.jhandler.getPayload(context).getClaim("role").asString();
        long param = Long.valueOf(context.pathParam(":id"));
        WagonClient.viewWagons(true, "Yelaman_Karassay").subscribe(new SingleObserver<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                try {
                    List<Vagon> vagons = WagonDeserealizator.getData(responseBody.string()).getVagon();
                    context.json(vagons);
                } catch (JAXBException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
