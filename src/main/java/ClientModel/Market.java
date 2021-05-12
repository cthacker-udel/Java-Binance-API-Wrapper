package ClientModel;

import Client.BinanceClient;

import java.util.HashMap;
import java.util.Map;

public class Market extends BinanceClient {

    private String symbol;
    private Integer limit;

    public HashMap<String,Object> generateQueries(){
        HashMap<String,Object> queries = new HashMap<String,Object>();
        if(this.symbol != null){
            queries.put("symbol",this.symbol);
        }
        if(this.limit != null){
            queries.put("limit",this.limit);
        }
        return queries;
    }

    public void clearQueries(){
        this.symbol = null;
        this.limit = null;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}