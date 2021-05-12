package InterfaceModel;

import Controller.MarketAPI.OrderBook;
import Controller.MarketAPI.RecentTrade;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.HashMap;
import java.util.List;

public interface marketInterface {

    @GET("https://api.binance.com/api/v3/depth")
    Call<OrderBook> getOrderBook(@QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/trades")
    Call<List<RecentTrade>> getRecentTrade(@QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.com/api/v3/historicalTrades")
    Call<List<RecentTrade>> getOldTrade(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
