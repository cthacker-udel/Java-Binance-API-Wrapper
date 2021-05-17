package Client;

import Controller.GeneralEndpointAPI.ExchangeInfo.ExchangeInfoRoot;
import Controller.GeneralEndpointAPI.ServerTime;

import Controller.MarketAPI.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import InterfaceModel.*;

import java.io.IOException;
import java.util.List;

public class BinanceRestAPI {

    public static String baseUrl = "https://api.binance.com/";


    /*
     *
     * General Endpoint API Methods
     *
     */


    /**
     *
     * Tests the connectivity to the server from the Client side
     *
     * @param client - BinanceClient instance
     * @return boolean - If BinanceClient instance is able to connect to server
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public boolean testConnectivity(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ping/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(InterfaceModel.generalInterface.class);

        Call<Void> testConnectivityCall = generalInterface.testConnectivity();

        Response<Void> testConnectivityResponse = testConnectivityCall.execute();

        return testConnectivityResponse.isSuccessful();

    }

    /**
     *
     * Gets Server Time using BinanceClient instance given
     * @param client - BinanceClient instance
     * @return Long - Server Time
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public Long getServerTime(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/time/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(InterfaceModel.generalInterface.class);

        Call<ServerTime> call = generalInterface.getServerTime();

        Response<ServerTime> response = call.execute();

        assert response.body() != null;
        return response.body().getServerTime();

    }


    /**
     *
     * Gets the current exchange trading rules and symbol information
     * @param client - BinanceClient instance
     * @return ExchangeInfoRoot instance
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public ExchangeInfoRoot getExchangeInformation(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/exchangeInfo/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(InterfaceModel.generalInterface.class);

        Call<ExchangeInfoRoot> call = generalInterface.getExchangeInformation();

        Response<ExchangeInfoRoot> response = call.execute();

        return response.body();

    }

    //#########################
    //# MARKET DATA API
    //########################

    public OrderBook getOrderBook(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/depth/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<OrderBook> call = marketInterface.getOrderBook(client.getMarket().generateQueries());

        Response<OrderBook> response = call.execute();

        return response.body();

    }

    public List<RecentTrade> getRecentTrades(BinanceClient client) throws IOException{

        String url = baseUrl + "/api/v3/trades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<List<RecentTrade>> call = marketInterface.getRecentTrade(client.getMarket().generateQueries());

        Response<List<RecentTrade>> response = call.execute();

        return response.body();

    }

    public List<RecentTrade> oldTradeLookup(BinanceClient client) throws IOException{

        String url = baseUrl + "/api/v3/historicalTrades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<List<RecentTrade>> call = marketInterface.getOldTrade(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<RecentTrade>> response = call.execute();

        return response.body();

    }

    public List<AggOrCompressedTrade> getAggregateOrCompressedTrades(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/aggTrades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<List<AggOrCompressedTrade>> call = marketInterface.getAggOrCompressedTrades(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<AggOrCompressedTrade>> response = call.execute();

        return response.body();

    }

    public List<List<Integer>> getKlineData(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/klines/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<List<List<Integer>>> call = marketInterface.getKlineData(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<List<Integer>>> response = call.execute();

        return response.body();

    }

    public AvgPrice getCurrentAveragePrice(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/avgPrice/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<AvgPrice> call = marketInterface.getAveragePrice(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<AvgPrice> response = call.execute();

        return response.body();

    }

    public TwentyFourPriceChange getTwentyFourPriceChange(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ticker/24hr/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<TwentyFourPriceChange> call = marketInterface.getTwentyFourHourChange(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<TwentyFourPriceChange> response = call.execute();

        return response.body();

    }

    public List<PriceTicker> getPriceTicker(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ticker/price/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(InterfaceModel.marketInterface.class);

        Call<List<PriceTicker>> call = marketInterface.getPriceTicker(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<PriceTicker>> response = call.execute();

        return response.body();

    }





}
