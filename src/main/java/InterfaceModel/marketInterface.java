package InterfaceModel;

import Controller.MarketAPI.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.HashMap;

public interface marketInterface {

    @GET("https://api.binance.com/api/v3/depth")
    Call<OrderBook> getOrderBook(@QueryMap HashMap<String,Object> queries);

}
