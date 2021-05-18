package InterfaceModel;

import Controller.AccountAPI.NewOrder;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.HashMap;

public interface accountInterface {

    @POST("https://api.binance.com/api/v3/order")
    Call<NewOrder> placeNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.binance.com/api/v3/order/test")
    Call<Void> testNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
