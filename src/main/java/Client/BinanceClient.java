package Client;


import ClientModel.Account;
import ClientModel.Market;

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

    Market market;

    Account account;

    public BinanceClient(){
        super();
    }

    public BinanceClient(String newApiKey, String newSecretKey){
        super();
        this.clientKeys = new BinanceClientKeys(newApiKey,newSecretKey);
        this.signatureMethods = new BinanceSignature();
        this.market = new Market();
        this.account = new Account();
    }

    public void generateSignature() throws NoSuchAlgorithmException, InvalidKeyException {
        this.signatureMethods.generateSignature(this.clientKeys.getSecretKey(),"ExampleTotalParams");
    }

    public BinanceClientKeys getClientKeys() {
        return clientKeys;
    }

    public BinanceSignature getSignatureMethods() {
        return signatureMethods;
    }

    public Market getMarket() {
        return market;
    }

    public Account getAccount() {
        return account;
    }
}