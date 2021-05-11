package Client;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author - Cameron Thacker - cthacker-udel
 *
 */



public class BinanceClient extends BinanceRestAPI {

    BinanceClientKeys clientKeys;

    BinanceSignature signatureMethods;

    public BinanceClient(){
        super();
    }

    public BinanceClient(String newApiKey, String newSecretKey){
        super();
        this.clientKeys = new BinanceClientKeys(newApiKey,newSecretKey);
        this.signatureMethods = new BinanceSignature();
    }

    public void generateSignature() throws NoSuchAlgorithmException, InvalidKeyException {
        this.signatureMethods.generateSignature(this.clientKeys.getSecretKey(),"ExampleTotalParams");
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        BinanceClient client = new BinanceClient("defaultApiKey","defaultSecretKey");
        client.generateSignature();
    }




}