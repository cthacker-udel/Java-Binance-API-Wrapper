package Client;


/**
 *
 * @author - Cameron Thacker - cthacker-udel
 *
 */



public class BinanceClient extends BinanceRestAPI {

    private String apiKey;

    private String secretKey;

    public BinanceClient(){
        super();
        this.apiKey = "defaultApiKey";
        this.secretKey = "defaultSecretKey";
    }


}