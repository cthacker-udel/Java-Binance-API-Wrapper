package Client;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinanceSignature extends BinanceClient{

    Mac hmac_256_algo;

    public String generateSignature(String secretKey, String totalParams) throws NoSuchAlgorithmException, InvalidKeyException {
        hmac_256_algo = Mac.getInstance("HmacSHA256");
        hmac_256_algo.init(new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8),"HmacSHA256"));
        byte[] byteResult = hmac_256_algo.doFinal(totalParams.getBytes(StandardCharsets.UTF_8));

        StringBuilder hash = new StringBuilder();
        for (byte b : byteResult) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }

        return hash.toString();
    }

}
