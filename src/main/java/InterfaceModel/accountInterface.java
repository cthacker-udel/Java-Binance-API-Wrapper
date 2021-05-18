package InterfaceModel;

import Controller.AccountAPI.NewOrder;
import Controller.AccountAPI.QueryOrder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.HashMap;

public interface accountInterface {

    @POST("https://api.binance.com/api/v3/order")
    Call<NewOrder> placeNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.binance.com/api/v3/order/test")
    Call<Void> testNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/order")
    Call<QueryOrder> queryOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
