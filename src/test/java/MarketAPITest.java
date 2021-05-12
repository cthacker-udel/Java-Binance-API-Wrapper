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
    void testGetOrderBook() throws IOException {
        client.getMarket().setSymbol("LTCBTC");
        assertNotNull(client.getOrderBook(client));
        client.getMarket().setLimit(5);
        assertNotNull(client.getOrderBook(client));
    }

    @Test
    void testRecentTrade() throws IOException{

        assertNotNull(client.getRecentTrades(client));

    }

    @Test
    void testOldTrade() throws IOException {
        client.getClientKeys().setApiKey("");
        assertNotNull(client.oldTradeLookup(client));

    }



}
