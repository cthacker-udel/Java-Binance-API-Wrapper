import Client.BinanceClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralEndpointTest {

    static BinanceClient client;

    static {
        client = new BinanceClient();
    }


    @Test
    void testConnectivityTest() throws IOException {
        assertTrue(client.testConnectivity(client));
    }

    @Test
    void testExchangeInformation() throws IOException {
        assertNotNull(client.getExchangeInformation(client));
    }

    @Test
    void testServerTime() throws IOException {
        assertNotNull(client.getServerTime(client));
    }

}
