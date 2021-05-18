package InterfaceModel;

import Controller.AccountAPI.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface accountInterface {

    @POST("https://api.binance.com/api/v3/order")
    Call<NewOrder> placeNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.binance.com/api/v3/order/test")
    Call<Void> testNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/order")
    Call<QueryOrder> queryOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @DELETE("https://api.binance.com/api/v3/order")
    Call<CancelOrder> cancelOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @DELETE("https://api.binance.com/api/v3/openOrders")
    Call<List<CancelOrder>> cancelAllActiveOrdersOnSymbol(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/openOrders")
    Call<List<OpenOrder>> getCurrentOpenOrders(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
