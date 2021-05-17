package ClientModel;

import Client.BinanceClient;

import java.math.BigDecimal;
import java.util.HashMap;

public class Account extends BinanceClient {

    private String symbol;
    private String side;
    private String type;
    private String timeInForce;
    private Double quantity;
    private Double quoteOrderQuantity;
    private Double price;
    private String newClientOrderId;
    private Double stopPrice;
    private Double icebergQuantity;
    private String newOrderResponseType;
    private Long receiveWindow;
    private Long timeStamp;

    public HashMap<String,Object> generateQueries(){
        HashMap<String,Object> queries = new HashMap<>();
        if(this.symbol != null){
            queries.put("symbol",this.symbol);
        }
        if(this.side != null){
            queries.put("side",this.side);
        }
        if(this.type != null){
            queries.put("type",this.type);
        }
        if(this.timeInForce != null){
            queries.put("timeInForce",this.timeInForce);
        }
        if(this.quantity != null){
            queries.put("quantity",this.quantity);
        }
        if(this.quoteOrderQuantity != null){
            queries.put("quoteOrderQty",this.quoteOrderQuantity);
        }
        if(this.price != null){
            queries.put("price",this.price);
        }
        if(this.newClientOrderId != null){
            queries.put("newClientOrderId",this.newClientOrderId);
        }
        if(this.stopPrice != null){
            queries.put("stopPrice",this.stopPrice);
        }
        if(this.icebergQuantity != null){
            queries.put("icebergQty",this.icebergQuantity);
        }
        if(this.newOrderResponseType != null){
            queries.put("newOrderRespType",this.newOrderResponseType);
        }
        if(this.receiveWindow != null){
            queries.put("recvWindow",this.receiveWindow);
        }
        if(this.timeStamp != null){
            queries.put("timestamp",this.timeStamp);
        }
        return queries;
    }

    public void clearQueries(){
        this.symbol = null;
        this.side = null;
        this.type = null;
        this.timeInForce = null;
        this.quantity = null;
        this.quoteOrderQuantity = null;
        this.price = null;
        this.newClientOrderId = null;
        this.stopPrice = null;
        this.icebergQuantity = null;
        this.newOrderResponseType = null;
        this.receiveWindow = null;
        this.timeStamp = null;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuoteOrderQuantity() {
        return quoteOrderQuantity;
    }

    public void setQuoteOrderQuantity(Double quoteOrderQuantity) {
        this.quoteOrderQuantity = quoteOrderQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNewClientOrderId() {
        return newClientOrderId;
    }

    public void setNewClientOrderId(String newClientOrderId) {
        this.newClientOrderId = newClientOrderId;
    }

    public Double getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Double stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Double getIcebergQuantity() {
        return icebergQuantity;
    }

    public void setIcebergQuantity(Double icebergQuantity) {
        this.icebergQuantity = icebergQuantity;
    }

    public String getNewOrderResponseType() {
        return newOrderResponseType;
    }

    public void setNewOrderResponseType(String newOrderResponseType) {
        this.newOrderResponseType = newOrderResponseType;
    }

    public Long getReceiveWindow() {
        return receiveWindow;
    }

    public void setReceiveWindow(Long receiveWindow) {
        this.receiveWindow = receiveWindow;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
