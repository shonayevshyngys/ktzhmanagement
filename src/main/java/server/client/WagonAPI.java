package client;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WagonAPI {
    @GET
    Single<ResponseBody> getWagon(@Url String url);
}
