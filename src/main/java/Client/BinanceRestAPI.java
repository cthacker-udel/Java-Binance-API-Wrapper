package Client;

import Controller.GeneralEndpointAPI.ExchangeInfo.ExchangeInfoRoot;
import Controller.GeneralEndpointAPI.ServerTime;

import Controller.MarketAPI.OrderBook;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import InterfaceModel.*;

import java.io.IOException;

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



}
