import Client.BinanceClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class MarketAPITest {

    static BinanceClient client;

    static {
        client = new BinanceClient("","");
    }


    @Test
    void test1() throws IOException {
        client.getMarket().setSymbol("LTCBTC");
        assertNotNull(client.getOrderBook(client));
        client.getMarket().setLimit(5);
        assertNotNull(client.getOrderBook(client));
    }

    @Test
    void test2() throws IOException{

        assertNotNull(client.getRecentTrades(client));

    }



}